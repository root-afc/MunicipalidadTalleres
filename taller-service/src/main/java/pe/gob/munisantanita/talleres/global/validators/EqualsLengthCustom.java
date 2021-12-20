package pe.gob.munisantanita.talleres.global.validators;

import pe.gob.munisantanita.talleres.global.validators.constraints.EqualsLengthValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EqualsLengthValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface EqualsLengthCustom {
    int value();
    String message() default "La logintud del campo debe no es correcta";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
