package hu.ak_akademia_spring_data_jpa_crud.domain.exception;

public class UnknownFieldException extends RuntimeException {
    public UnknownFieldException(final String message) {
        super(message);
    }
}
