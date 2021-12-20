package pe.gob.munisantanita.talleres.global.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import pe.gob.munisantanita.talleres.endpoint.matriculas.entity.Matricula;
import pe.gob.munisantanita.talleres.endpoint.matriculas.entity.MatriculaDetalle;
import pe.gob.munisantanita.talleres.endpoint.secciones.entity.Seccion;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class Email {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarMail(Matricula matricula){
        MimeMessage mimeMessage = mailSender.createMimeMessage();
    }
}
