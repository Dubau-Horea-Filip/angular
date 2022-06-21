package core.model.validators;
import core.exceptions.ValidatorException;



public interface Validator<T> {
    void validate(T entity) throws ValidatorException;
}
