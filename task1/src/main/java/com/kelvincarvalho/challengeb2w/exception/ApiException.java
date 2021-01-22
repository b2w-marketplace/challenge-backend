package com.kelvincarvalho.challengeb2w.exception;

import java.io.Serializable;

public class ApiException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = -6882421844496689191L;

    private String message;

    public ApiException(String msg) {
        super(msg);
        message = msg;
    }
    
    public String getMessage()

    {
        return message;
    }

}
