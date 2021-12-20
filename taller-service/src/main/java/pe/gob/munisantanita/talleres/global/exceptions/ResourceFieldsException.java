package pe.gob.munisantanita.talleres.global.exceptions;

import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class ResourceFieldsException extends Exception{

    private static final long serialVersionUID = 1L;

    public ResourceFieldsException(String[][] object){
        super((new Gson()).toJson(object));
    }
}