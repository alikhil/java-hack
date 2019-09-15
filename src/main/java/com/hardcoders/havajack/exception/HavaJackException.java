package com.hardcoders.havajack.exception;

class HavaJackException extends Exception {

    HavaJackException() {
    }

    HavaJackException(String message) {
        super(message);
    }

    HavaJackException(String message, Throwable cause) {
        super(message, cause);
    }

    HavaJackException(Throwable cause) {
        super(cause);
    }

    HavaJackException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
