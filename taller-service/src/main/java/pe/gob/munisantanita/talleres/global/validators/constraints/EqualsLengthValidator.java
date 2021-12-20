package pe.gob.munisantanita.talleres.global.validators.constraints;


import pe.gob.munisantanita.talleres.global.validators.EqualsLengthCustom;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EqualsLengthValidator implements ConstraintValidator<EqualsLengthCustom, String> {
    int length;

    @Override
    public void initialize(EqualsLengthCustom constraintAnnotation) {
        length = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value != null && value.length() >= length){
            return true;
        }
        return false;
    }
}
