package io.qkits.common.exception;

/**
 * @author patrick
 */
public class APITestException extends RuntimeException {

    public APITestException() {
        super();
    }

    public APITestException(String message) {
        super(message);
    }

    public APITestException(String message, Throwable cause) {
        super(message, cause);
    }

    public APITestException(Throwable cause) {
        super(cause);
    }

    protected APITestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}