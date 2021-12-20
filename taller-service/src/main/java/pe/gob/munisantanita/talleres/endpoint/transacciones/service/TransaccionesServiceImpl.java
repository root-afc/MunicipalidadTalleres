package pe.gob.munisantanita.talleres.endpoint.transacciones.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.*;
import pe.gob.munisantanita.talleres.endpoint.apoderados.entity.Apoderado;
import pe.gob.munisantanita.talleres.endpoint.apoderados.repository.ApoderadosRepository;
import pe.gob.munisantanita.talleres.endpoint.estudiante.entity.Estudiante;
import pe.gob.munisantanita.talleres.endpoint.estudiante.repository.EstudiantesRepository;
import pe.gob.munisantanita.talleres.endpoint.matriculas.entity.Matricula;
import pe.gob.munisantanita.talleres.endpoint.matriculas.entity.MatriculaDetalle;
import pe.gob.munisantanita.talleres.endpoint.matriculas.repository.MatriculasDetallesRepository;
import pe.gob.munisantanita.talleres.endpoint.matriculas.repository.MatriculasRepository;
import pe.gob.munisantanita.talleres.endpoint.secciones.entity.Seccion;
import pe.gob.munisantanita.talleres.endpoint.secciones.repository.SeccionesRepository;
import pe.gob.munisantanita.talleres.endpoint.transacciones.entity.*;
import pe.gob.munisantanita.talleres.endpoint.transacciones.repository.TransaccionesRepository;
import pe.gob.munisantanita.talleres.global.exceptions.ResourceFieldsException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.sound.midi.SysexMessage;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.ConnectException;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Service
public class TransaccionesServiceImpl implements TransaccionesService {

    @Autowired
    private TransaccionesRepository transaccionesRepository;


    @Autowired
    private EstudiantesRepository estudiantesRepository;

    @Autowired
    private ApoderadosRepository apoderadosRepository;

    @Autowired
    private SeccionesRepository seccionesRepository;

    @Autowired
    private MatriculasRepository matriculasRepository;

    @Autowired
    private MatriculasDetallesRepository matriculasDetallesRepository;


    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RestTemplate restTemplateSiget;



    @Value("${Niubiz.authorization}")
    private String niubizAuthorization;


    @Override
    public Transaccion save(Transaccion object) {
       return transaccionesRepository.save(object);
    }

    @Override
    public Transaccion update(Transaccion object) throws ResourceFieldsException {

        if(object.getId() <= 0) throw new ResourceFieldsException( new String[][]{new String[] {"id","El id de la seccion es requerido"}});
        transaccionesRepository.findById(object.getId()).orElseThrow(() -> new ResourceFieldsException( new String[][]{new String[] {"id","El id de la seccion no existe"}} ));
        return transaccionesRepository.save(object);
    }

    @Override
    public void deleteById(Long id) {
        //
    }

    @Override
    public Transaccion findById(Long id) throws ResourceFieldsException {
        return null;
    }

    @Override
    public List<Transaccion> findAll() {
        return transaccionesRepository.findAll();
    }


    @Override
    public Object constancia(Operacion operacion) {

        Estudiante estudiante = estudiantesRepository.findByDni(operacion.getEstudiante().getDni());
        if(estudiante != null) operacion.getEstudiante().setId(estudiante.getId());
        operacion.getEstudiante().setApoderado_id((long) 0);
        estudiante = estudiantesRepository.save(operacion.getEstudiante());


        if(operacion.getApoderado() != null) {
            Apoderado apo = operacion.getApoderado();
            apo.setEstudiante(estudiante);

            Apoderado apoderado = apoderadosRepository.findByDni(apo.getDni());
            if(apoderado != null) operacion.getApoderado().setId(apoderado.getId());
            apoderado = apoderadosRepository.save(apo);

            estudiante.setApoderado_id(apoderado.getId());
            estudiante = estudiantesRepository.save(estudiante);
        }

        double importe  = 0;
        for (Seccion sec: operacion.getSecciones()) {
            Seccion seccion = seccionesRepository.findById(sec.getId()).orElse(null);
            if(seccion != null) importe += seccion.getPrecio();
        }

        Matricula matricula = new Matricula();
        matricula.setEstudiante(estudiante);
        matricula.setEstado(0);//Pendiente
        matricula.setRecibo_id("");
        matricula.setNro_recibo("");
        matricula.setFecha(new Date());
        matricula.setImporte(importe);
        matricula = matriculasRepository.save(matricula);

        List<Concepto> conceptoList = new ArrayList<>();

        for (Seccion sec: operacion.getSecciones()){

            Seccion seccion = seccionesRepository.findById(sec.getId()).orElse(null);
            if(seccion != null) {
                Concepto c =  new Concepto();
                c.setTupa_id(1785);
                c.setMonto_pago(seccion.getPrecio());
                c.setCantidad(1);
                conceptoList.add(c);
                MatriculaDetalle detalle = new MatriculaDetalle();
                detalle.setSeccion(seccion);
                detalle.setMatricula_id(matricula.getId());
                detalle.setDescuento(0);
                detalle.setImporte(seccion.getPrecio());
                detalle = matriculasDetallesRepository.save(detalle);

            }
        }

        operacion.getAutorizacion().getOrder().setAmount(importe+"");
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", operacion.getAutorizacion().getTransactionToken()  );
        HttpEntity<Autorizacion> entity = new HttpEntity<>(operacion.getAutorizacion(), headers);

        Transaccion transaccion = new Transaccion();
        transaccion.setPurchaseNumber(operacion.getAutorizacion().getOrder().getPurchaseNumber());
        transaccion.setTransaccion_id(operacion.getAutorizacion().getOrder().getTokenId());
        transaccion.setFecha(new Date());
        transaccion.setEstado("PENDIENTE");
        transaccion = transaccionesRepository.save(transaccion);

        try {
            ResponseEntity<String> response = restTemplate.exchange(niubizAuthorization, HttpMethod.POST, entity, String.class);
            String res = response.getBody();

            JsonObject convertedObject = new Gson().fromJson(res, JsonObject.class);
            JsonElement status = convertedObject.getAsJsonObject("dataMap").get("STATUS");
            String estado = "";
            if(status != null && status.getAsString().equals("Authorized")){

                for (Seccion sec: operacion.getSecciones()){
                    Seccion seccion = seccionesRepository.findById(sec.getId()).orElse(null);
                    if(seccion != null){
                        seccion.setInscritos(seccion.getInscritos() + 1);
                        seccionesRepository.save(seccion);
                    }
                }

                transaccion.setEstudiante_id(estudiante.getId());
                transaccion.setMonto_total(importe);
                transaccion.setTipo_tarjeta(convertedObject.getAsJsonObject("dataMap").get("BRAND").getAsString());
                transaccion.setCard(convertedObject.getAsJsonObject("dataMap").get("CARD").getAsString());
                transaccion.setCurrency(convertedObject.getAsJsonObject("order").get("currency").getAsString());

                transaccion.setPurchaseNumber(operacion.getAutorizacion().getOrder().getPurchaseNumber());
                transaccion.setRespuesta_json(res);
                transaccion.setEstado("INCOMPLETO");
                transaccion = transaccionesRepository.save(transaccion);


                matricula.setEstado(1);
                Integer ram = (int)
                        ((Math.random() * (100 - 1)) + 1);
                matricula.setNro_recibo("" + ram);
                matricula.setRecibo_id("" + ram);
                matricula.setTransaccion(transaccion);
                matricula = matriculasRepository.save(matricula);

                matricula.setDetalles(matriculasDetallesRepository.findByMatricula_id(matricula.getId()));


                matricula.setNro_recibo("" + ram);
                matricula.setRecibo_id("" + ram);
                matricula = matriculasRepository.save(matricula);

                transaccion.setEstado("COMPLETADO");
                transaccionesRepository.save(transaccion);
                estado = "COMPLETO";

            }
            else{
                // Si en la consulta de niubiz no fue exitosa
                transaccion.setEstudiante_id(estudiante.getId());
                transaccion.setMonto_total(importe);
                transaccion.setPurchaseNumber(operacion.getAutorizacion().getOrder().getPurchaseNumber());
                transaccion.setRespuesta_json(res);
                transaccion.setEstado("ERROR_NIUBIZ_FAIL");
                transaccionesRepository.save(transaccion);
            }

            Respuesta respuesta = new Respuesta();
            respuesta.setEstudiante(estudiante);
            respuesta.setMatricula(matricula);
            respuesta.setEstado(estado);
            respuesta.setTransaccion(new Gson().fromJson(res, Transaccion.class));

            return respuesta;

        } catch(final HttpServerErrorException | HttpClientErrorException e) {

            transaccion.setEstudiante_id(estudiante.getId());
            transaccion.setMonto_total(importe);
            transaccion.setPurchaseNumber(operacion.getAutorizacion().getOrder().getPurchaseNumber());
            transaccion.setRespuesta_json(e.getResponseBodyAsString());
            transaccion.setEstado("ERROR_NIUBIZ");
            transaccionesRepository.save(transaccion);

            matricula.setTransaccion(transaccion);
            matriculasRepository.save(matricula);

            return e.getResponseBodyAsString();
        }

    }


}
