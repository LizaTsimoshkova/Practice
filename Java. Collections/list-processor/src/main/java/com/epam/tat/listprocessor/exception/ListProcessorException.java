package com.epam.tat.listprocessor.exception;

public class ListProcessorException extends RuntimeException {

    public ListProcessorException() {
    }

    public ListProcessorException(String message) {
        super(message);
    }

    public ListProcessorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ListProcessorException(Throwable cause) {
        super(cause);
    }

    protected ListProcessorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
