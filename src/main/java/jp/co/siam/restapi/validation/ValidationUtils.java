package jp.co.siam.restapi.validation;


import org.hibernate.validator.HibernateValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class ValidationUtils {


    private static final Validator validator = Validation
            .byProvider(HibernateValidator.class).configure().failFast(false).buildValidatorFactory().getValidator();


    public static <T> List<ValidationError> validateDetail(T obj, Class... group) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(obj);
        List<ValidationError> errors = new ArrayList<ValidationError>();
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<T> constraintViolation : constraintViolations) {
                errors.add(toError(constraintViolation));
            }
        }
        return errors;
    }

    public static <T> String validate(T obj, Class... group) {
        List<ValidationError> errors = validateDetail(obj);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < errors.size(); i++) {
            sb.append(errors.get(i).getMessage());
            if (i != errors.size()) {
                sb.append("</br>");
            }
        }
        if (sb.toString().trim().equals("")) {
            return null;
        }
        return sb.toString();
    }

    private static <T> ValidationError toError(ConstraintViolation<T> constraintViolation) {
        ValidationError err = new ValidationError();
        err.setFieldName(constraintViolation.getPropertyPath().toString());
        err.setMessage(constraintViolation.getMessage());
        return err;
    }
}
