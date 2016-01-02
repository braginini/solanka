package io.solanka.common.exception;

/**
 * Common exception thrown while parsing
 */
public class ParseException extends RuntimeException {

    /**
     * Creates an instance with given message
     *
     * @param message the message of the exception
     */
    public ParseException(String message) {
        super(message);
    }

    /**
     * Creates an instance with given message and cause
     *
     * @param message the message of the exception
     * @param cause the cause of the exception
     */
    public ParseException(String message, Throwable cause) {
        super(message, cause);
    }
}
