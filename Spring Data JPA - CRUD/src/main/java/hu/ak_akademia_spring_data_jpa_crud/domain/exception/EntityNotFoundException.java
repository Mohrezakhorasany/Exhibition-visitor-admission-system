package hu.ak_akademia_spring_data_jpa_crud.domain.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(final String message) {
        super(message);
    }
}
