package com.b2w.desafiob2w.dto;
/*
    Tiago Iwamoto
    tiago.iwamoto@gmail.com
    System Analyst
    MBA Business Intelligence

    Classe utilizada para transitar objetos pela aplicação
*/

public class B2wDto<T> extends AbstractDto {

    private T obj;

    public B2wDto(Integer code, String message) {
        super(code, message);
    }

    public B2wDto(Integer code, String message, T obj) {
        super(code, message);
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
