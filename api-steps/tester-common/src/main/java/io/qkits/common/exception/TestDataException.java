package io.qkits.common.exception;

public class TestDataException extends RuntimeException {


    public TestDataException() {
    }

    public TestDataException(String message) {
        super(message);
    }

    public TestDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public TestDataException(Throwable cause) {
        super(cause);
    }

    public TestDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
