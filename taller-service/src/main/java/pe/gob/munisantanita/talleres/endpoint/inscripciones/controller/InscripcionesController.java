package pe.gob.munisantanita.talleres.endpoint.inscripciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import pe.gob.munisantanita.talleres.endpoint.inscripciones.entity.Inscripcion;
import pe.gob.munisantanita.talleres.endpoint.inscripciones.entity.InscripcionPorSecciones;
import pe.gob.munisantanita.talleres.global.models.Response;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/inscripciones")
public class InscripcionesController {


    @Autowired
    private JdbcTemplate jdbcTemplate;



    @GetMapping
    public Response<List<Inscripcion>> findAllInscritos() {

        List<Inscripcion> lista =  jdbcTemplate.query("select S.id  AS 'id', T.nombre AS 'taller', C.nombre AS 'categoria', Ed.nombre AS 'edad', H.nombre AS 'hora', D.nombre AS  'dia', E.id AS 'e_id', E.nombres AS 'e_nombre', E.ape_paterno AS 'e_ape_paterno', E.ape_materno AS 'e_ape_materno', E.dni AS 'e_dni', E.movil AS 'e_movil', E.correo AS 'e_correo', E.fecha_nacimiento AS 'e_fecha_nacimiento', M.fecha, M.id AS 'm_id' from matriculas_detalles MD inner join matriculas M on M.id = MD.matricula_id inner join secciones S on S.id = MD.seccion_id inner join estudiantes E on E.id = M.estudiante_id inner join talleres T on T.id = S.taller_id inner join categorias C on C.id = T.categoria_id inner join edades Ed on Ed.id = S.edad_id inner join horas H on H.id = S.hora_id inner join dias D on D.id = S.dia_id where S.estado = 1 and M.estado = 1 order by M.fecha desc",
                    new BeanPropertyRowMapper<>(Inscripcion.class));

        return new Response<List<Inscripcion>>().setData(lista);
    }

    @GetMapping("/total-de-inscritos-por-secciones")
    public Response<List<InscripcionPorSecciones>> totalInscritrosPorSecciones() {
// "select S.id AS 's_id', C.nombre AS 'c_nombre', T.nombre AS 't_nombre', E.nombre AS 'e_nombre', H.nombre AS 'h_nombre', D.nombre AS 'd_nombre', CAST(S.precio as decimal(19,2)) AS 's_precio', S.maximo AS 's_maximo', S.inscritos AS 's_inscritos' from secciones S inner join talleres T on T.id = S.taller_id inner join edades E on E.id = S.edad_id inner join horas H on H.id = S.hora_id inner join dias D on D.id = S.dia_id inner join categorias C on C.id = T.categoria_id where C.estado = 1 and S.estado = 1 order by c_nombre, t_nombre asc"
        List<InscripcionPorSecciones> lista_tmp = new ArrayList<>();
        List<InscripcionPorSecciones> lista =  jdbcTemplate.query("select S.id, C.nombre Categoria, T.nombre Taller, E.nombre Edad, H.nombre Hora, D.nombre Dia, CAST(S.precio as decimal(19,2)) precio, S.maximo, S.inscritos Total_Inscritos from secciones S inner join talleres T on T.id = S.taller_id inner join edades E on E.id = S.edad_id inner join horas H on H.id = S.hora_id inner join dias D on D.id = S.dia_id inner join categorias C on C.id = T.categoria_id where C.estado = 1 and S.estado = 1 order by Total_Inscritos desc",
                new BeanPropertyRowMapper<>(InscripcionPorSecciones.class));

        return new Response<List<InscripcionPorSecciones>>().setData(lista);
    }




}
