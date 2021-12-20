package pe.gob.munisantanita.talleres.global.validators;


import pe.gob.munisantanita.talleres.global.validators.constraints.LargoStringValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = LargoStringValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface LargoString {
    int value();
    String message() default "El campo es requerido xx";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
