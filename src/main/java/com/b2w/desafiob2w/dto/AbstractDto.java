package com.b2w.desafiob2w.dto;
/*
    Tiago Iwamoto
    tiago.iwamoto@gmail.com
    System Analyst
    MBA Business Intelligence
*/

public abstract class AbstractDto {

    //region ATRIBUTOS
    private Integer code;
    private String message;
    //endregion

    //region CONSTRUTORES
    public AbstractDto(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    //endregioni

    //region GETTERS AND SETTERS
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    //endregion
}
