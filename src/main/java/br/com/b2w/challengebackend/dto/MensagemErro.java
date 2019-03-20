package br.com.b2w.challengebackend.dto;

import java.io.Serializable;

/**
 * Created by anderson on 03/11/16.
 */
public class MensagemErro implements Serializable {

    private String mensagem;

    public MensagemErro() {

    }

    public MensagemErro(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
