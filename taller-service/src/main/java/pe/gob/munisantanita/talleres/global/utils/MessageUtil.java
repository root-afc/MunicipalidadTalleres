package pe.gob.munisantanita.talleres.global.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import pe.gob.munisantanita.talleres.global.config.AppConfig;

import java.util.Locale;

@Component

public class MessageUtil {

    @Autowired
    private AppConfig appConfig;

    public String getExceptionMessage(String code, Exception exception, MessageSource messageSource, Locale locale){
        if(appConfig.getDebug()){
            return exception.getMessage();
        }

        String message = null;
        try{
            message = messageSource.getMessage(code, null, locale);
        } catch (Exception ex){
            message = exception.getMessage();
        }
        return message;
    }

    public String getMessage(String code, MessageSource messageSource, Locale locale){
        String message = null;
        try{
            message = messageSource.getMessage(code, null, locale);
        } catch (Exception ex){
            message = code;
        }
        return message;
    }
}