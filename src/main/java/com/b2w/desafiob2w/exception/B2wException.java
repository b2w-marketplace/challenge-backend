package com.b2w.desafiob2w.exception;
/*
    Tiago Iwamoto
    tiago.iwamoto@gmail.com
    System Analyst
    MBA Business Intelligence
*/

public class B2wException extends Exception {

    public B2wException() {
    }

    public B2wException(String message) {
        super(message);
    }

    public B2wException(String message, Throwable cause) {
        super(message, cause);
    }

    public B2wException(Throwable cause) {
        super(cause);
    }

    public B2wException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
