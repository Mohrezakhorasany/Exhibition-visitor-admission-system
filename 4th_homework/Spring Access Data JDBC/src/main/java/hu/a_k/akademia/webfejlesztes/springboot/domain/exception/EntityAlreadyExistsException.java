package hu.a_k.akademia.webfejlesztes.springboot.domain.exception;

public class EntityAlreadyExistsException extends RuntimeException {
    public EntityAlreadyExistsException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
