package br.com.b2w.challengebackend.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

import br.com.b2w.challengebackend.dto.MensagemErro;

/**
 * Created by anderson on 03/11/16.
 */
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public MensagemErro handleException(HttpServletRequest request, Exception ex) {

        return new MensagemErro("Operação indisponivel, por favor contate o administrador do sistema.");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public MensagemErro handleMethodArgumentNotValidException(HttpServletRequest request, Exception ex) {
        return new MensagemErro("Os parametros não foram preenchido corretamente.");
    }

    @ExceptionHandler(ServletRequestBindingException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public MensagemErro handleServletRequestBindingException(HttpServletRequest request, Exception ex) {
        return new MensagemErro("Erro ao acessar o serviço");
    }
}
