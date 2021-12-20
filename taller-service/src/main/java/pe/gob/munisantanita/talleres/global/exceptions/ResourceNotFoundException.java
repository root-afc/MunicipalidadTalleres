package pe.gob.munisantanita.talleres.global.exceptions;

public class ResourceNotFoundException extends Exception {
    private static final long serialVersionUID = -3350324960963472023L;
    public ResourceNotFoundException(String message){
        super(message);
    }
}
