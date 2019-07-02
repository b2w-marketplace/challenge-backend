package com.b2w.desafiob2w.enums;
/*
    Tiago Iwamoto
    tiago.iwamoto@gmail.com
    System Analyst
    MBA Business Intelligence
*/

public enum B2wMessages {
    EMPTY_LIST("Lista vazia."),
    NULL_OBJECT("Falha ao iniciar objeto."),
    EX("Falha na comunicação com o serviço."),
    RECOVERED("Recuperado com sucesso.");

    private String value;

    B2wMessages(String value) {
        this.value = value;
    }

    public String get() {
        return value;
    }
}
