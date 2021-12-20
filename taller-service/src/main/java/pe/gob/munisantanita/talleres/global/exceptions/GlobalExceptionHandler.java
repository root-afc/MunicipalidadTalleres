package pe.gob.munisantanita.talleres.global.exceptions;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import pe.gob.munisantanita.talleres.global.models.ErrorMessage;
import pe.gob.munisantanita.talleres.global.models.Response;
import pe.gob.munisantanita.talleres.global.utils.MessageUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {


    @Autowired
    private MessageSource messageSource;

    @Autowired
    private MessageUtil messageUtil;

    Locale currentLocale =  LocaleContextHolder.getLocale();

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response<Object> methodArgumentTypeMismatchExceptionHandler(MethodArgumentTypeMismatchException ex, HttpServletRequest request) {

        String errorMessage = messageUtil.getExceptionMessage(MethodArgumentTypeMismatchException.class.getSimpleName().toString(), ex, messageSource, currentLocale);
        errorMessage = errorMessage.replace("{0}", ex.getValue().toString());
        errorMessage = errorMessage.replace("{1}", ex.getParameter().getParameterName());
        errorMessage = errorMessage.replace("{2}", ex.getParameter().getParameterType().toString());
        return new Response<Object>()
                .setCode(HttpStatus.BAD_REQUEST.value())
                .setStatus(messageUtil.getMessage("MSG_ERROR_INVALID_INPUT", messageSource, currentLocale))
                .setMessage(errorMessage);
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response<Object> bindExceptionHandler(BindException ex) {
        return new Response<Object>()
                .setCode(HttpStatus.BAD_REQUEST.value())
                .setStatus(messageUtil.getMessage("MSG_ERROR_INVALID_INPUT", messageSource, currentLocale))
                .setMessage(messageUtil.getExceptionMessage(BindException.class.getSimpleName().toString(), ex, messageSource, currentLocale))
                .setErrors(processFieldErrors(ex.getBindingResult().getFieldErrors()));
    }

    @ExceptionHandler(ConversionFailedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response<Object> conversionFailedExceptionHandler(ConversionFailedException ex) {
        String errorMessage = messageUtil.getExceptionMessage(ConversionFailedException.class.getSimpleName().toString(), ex, messageSource, currentLocale);
        errorMessage = errorMessage.replace("{0}", ex.getValue().toString());
        errorMessage = errorMessage.replace("{1}", ex.getSourceType().toString());
        errorMessage = errorMessage.replace("{2}", ex.getTargetType().toString());
        return new Response<Object>()
                .setCode(HttpStatus.BAD_REQUEST.value())
                .setStatus(messageUtil.getMessage("MSG_ERROR_INVALID_INPUT", messageSource, currentLocale))
                .setMessage(errorMessage);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response<Object> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
        return new Response<Object>()
                .setCode(HttpStatus.BAD_REQUEST.value())
                .setStatus(messageUtil.getMessage("MSG_ERROR_INVALID_INPUT", messageSource, currentLocale))
                .setMessage(messageUtil.getExceptionMessage(MethodArgumentNotValidException.class.getSimpleName().toString(), ex, messageSource, currentLocale))
                .setErrors(processFieldErrors(ex.getBindingResult().getFieldErrors()));
    }

    @ExceptionHandler(ResourceFieldsException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response<Object> resourceFieldsExceptionHandler(ResourceFieldsException ex) {
        List<ErrorMessage> errors = new ArrayList<ErrorMessage>();
        for (String[] F: (new Gson()).fromJson(ex.getMessage(), String[][].class)) errors.add(new ErrorMessage(F[0], F[1]));

        return new Response<Object>()
                .setCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .setStatus(messageUtil.getMessage("MSG_ERROR_INVALID_INPUT", messageSource, currentLocale))
                .setMessage(messageUtil.getExceptionMessage(MethodArgumentNotValidException.class.getSimpleName().toString(), ex, messageSource, currentLocale))
                .setErrors(errors);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response<Object> httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException ex){
        if(ex.getCause() != null && ex.getCause() instanceof InvalidFormatException){
            InvalidFormatException exInvalid = (InvalidFormatException) ex.getCause();
            String errorMessage = messageUtil.getExceptionMessage(InvalidFormatException.class.getSimpleName().toString(), exInvalid, messageSource, currentLocale);
            errorMessage = errorMessage.replace("{0}", exInvalid.getValue().toString());
            errorMessage = errorMessage.replace("{1}", exInvalid.getPath().get(0).getFieldName());
            errorMessage = errorMessage.replace("{2}", exInvalid.getTargetType().toString());
            return new Response<Object>()
                    .setCode(HttpStatus.BAD_REQUEST.value())
                    .setStatus(messageUtil.getMessage("MSG_ERROR_INVALID_INPUT", messageSource, currentLocale))
                    .setMessage(errorMessage);
        }
        String errorMessage = messageUtil.getExceptionMessage(HttpMessageNotReadableException.class.getSimpleName().toString(), ex, messageSource, currentLocale);
        return new Response<Object>()
                .setCode(HttpStatus.BAD_REQUEST.value())
                .setStatus(messageUtil.getMessage("MSG_ERROR_INVALID_INPUT", messageSource, currentLocale))
                .setMessage(errorMessage);
    }

    @ExceptionHandler(InvalidDataAccessApiUsageException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Response<Object> invalidDataAccessApiUsageExceptionHandler(InvalidDataAccessApiUsageException ex) {
        String errorMessage = messageUtil.getExceptionMessage(InvalidDataAccessApiUsageException.class.getSimpleName().toString(), ex, messageSource, currentLocale);
        return new Response<Object>()
                .setCode(HttpStatus.NOT_FOUND.value())
                .setStatus(messageUtil.getMessage("MSG_ERROR_INVALID_INPUT", messageSource, currentLocale))
                .setMessage(errorMessage);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Response<Object> resourceNotFoundExceptionHandler(ResourceNotFoundException ex) {
        return new Response<Object>()
                .setCode(HttpStatus.NOT_FOUND.value())
                .setStatus(messageUtil.getMessage("MSG_ERROR_NOT_FOUND", messageSource, currentLocale))
                .setMessage(ex.getMessage());
    }

    @ExceptionHandler(ResourceExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response<Object> resourceExistExceptionHandler(ResourceExistException ex) {
        return new Response<Object>()
                .setCode(HttpStatus.BAD_REQUEST.value())
                .setStatus(messageUtil.getMessage("MSG_ERROR_RESOURCE_EXIST", messageSource, currentLocale))
                .setMessage(ex.getMessage());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Response<Object> noHandlerFoundExceptionHandler(NoHandlerFoundException ex, HttpServletRequest request) {
        String errorMessage = messageUtil.getExceptionMessage(NoHandlerFoundException.class.getSimpleName().toString(), ex, messageSource, currentLocale);
        errorMessage = errorMessage.replace("{0}", request.getRequestURI());
        errorMessage = errorMessage.replace("{1}", request.getMethod());
        return new Response<Object>()
                .setCode(HttpStatus.NOT_FOUND.value())
                .setStatus(messageUtil.getMessage("MSG_ERROR_NOT_FOUND", messageSource, currentLocale))
                .setMessage(errorMessage);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public Response<Object> httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException ex, HttpServletRequest request) {
        String errorMessage = messageUtil.getExceptionMessage(HttpRequestMethodNotSupportedException.class.getSimpleName().toString(), ex, messageSource, currentLocale);
        errorMessage = errorMessage.replace("{0}", request.getRequestURI());
        errorMessage = errorMessage.replace("{1}", request.getMethod());
        return new Response<Object>()
                .setCode(HttpStatus.METHOD_NOT_ALLOWED.value())
                .setStatus(messageUtil.getMessage("MSG_ERROR_METHOD_NOT_SUPPORTED", messageSource, currentLocale))
                .setMessage(errorMessage);
    }

    private List<ErrorMessage> processFieldErrors(List<FieldError> fieldErrors) {
        List<ErrorMessage> errors = new ArrayList<ErrorMessage>();
        for (FieldError fieldError: fieldErrors) {
            String localizedErrorMessage = resolveLocalizedErrorMessage(fieldError);
            errors.add(new ErrorMessage(fieldError.getField(), localizedErrorMessage));
        }
        return errors;
    }

    private String resolveLocalizedErrorMessage(FieldError resource) {
        return messageSource.getMessage(resource, currentLocale);
    }
}

