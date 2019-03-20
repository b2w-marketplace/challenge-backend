package br.com.b2w.challengebackend.exception;

/**
 * Created by anderson on 03/11/16.
 */
public class ItemNaoEncotradoException extends RuntimeException {

    public ItemNaoEncotradoException() {
        super("Nao foram encontratos itens com parametros informados.");
    }
}
