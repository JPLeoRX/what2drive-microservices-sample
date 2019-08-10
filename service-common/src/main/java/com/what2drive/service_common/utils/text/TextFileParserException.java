package com.what2drive.service_common.utils.text;

public class TextFileParserException extends RuntimeException {
    public TextFileParserException() {

    }

    public TextFileParserException(String message) {
        super(message);
    }

    public TextFileParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public TextFileParserException(Throwable cause) {
        super(cause);
    }

    public TextFileParserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}