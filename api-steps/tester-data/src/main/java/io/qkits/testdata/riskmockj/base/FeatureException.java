package io.qkits.testdata.mock.base;

/**
 * @author patrick
 */
public class FeatureException extends RuntimeException {
    public FeatureException() {
        super();
    }

    public FeatureException(String message) {
        super(message);
    }

    public FeatureException(String message, Throwable cause) {
        super(message, cause);
    }

    public FeatureException(Throwable cause) {
        super(cause);
    }

    protected FeatureException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
