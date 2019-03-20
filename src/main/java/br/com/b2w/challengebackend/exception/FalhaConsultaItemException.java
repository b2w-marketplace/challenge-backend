package br.com.b2w.challengebackend.exception;

/**
 * Created by anderson on 03/11/16.
 */
public class FalhaConsultaItemException extends RuntimeException {

    public FalhaConsultaItemException() {
        super("Ocorreu um erro ao acessar a api de consulta.");
    }
}
