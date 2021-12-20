package pe.gob.munisantanita.talleres.global.exceptions;

public class ResourceExistException extends Exception{
    private static final long serialVersionUID = -3817805028340069101L;

    public ResourceExistException(String message){
        super(message);
    }
}
