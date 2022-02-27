package hu.ak_akademia.spring_boot_rest.domain.exception;

public class UnknownFieldException extends RuntimeException {
    public UnknownFieldException(final String message) {
        super(message);
    }
}
