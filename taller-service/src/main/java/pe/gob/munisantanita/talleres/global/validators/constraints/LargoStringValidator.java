package pe.gob.munisantanita.talleres.global.validators.constraints;


import pe.gob.munisantanita.talleres.global.validators.LargoString;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LargoStringValidator implements ConstraintValidator<LargoString, String> {

    int largo;

    @Override
    public void initialize(LargoString constraintAnnotation) {
        largo = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value != null && value.length() >= largo){
            return true;
        }
        return false;
    }
}
