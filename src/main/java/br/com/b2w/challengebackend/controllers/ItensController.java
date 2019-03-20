package br.com.b2w.challengebackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.com.b2w.challengebackend.dto.Item;
import br.com.b2w.challengebackend.dto.MensagemErro;
import br.com.b2w.challengebackend.exception.FalhaConsultaItemException;
import br.com.b2w.challengebackend.exception.ItemNaoEncotradoException;
import br.com.b2w.challengebackend.services.ItensService;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by anderson on 03/11/16.
 */

@RestController
@RequestMapping("/challenge-backend")
public class ItensController {

    public static final String FORMATO_DATA = "dd-MM-yyyy";

    @Autowired
    ItensService service;

    @RequestMapping(value = "/item", method = RequestMethod.GET, produces = {APPLICATION_JSON_VALUE, APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<List<Item>> pesquisarItensProduto(@RequestParam(required = true, name = "begindate") @DateTimeFormat(pattern = FORMATO_DATA) final Date inicio, @RequestParam(required = true, name = "finaldate") @DateTimeFormat(pattern = FORMATO_DATA) final Date fim) throws ItemNaoEncotradoException, FalhaConsultaItemException {

        LocalDateTime pInicio = LocalDateTime.ofInstant(inicio.toInstant(), ZoneId.systemDefault());
        LocalDateTime pFim = LocalDateTime.ofInstant(fim.toInstant(), ZoneId.systemDefault());

        List<Item> itens = service.consultarItemProduto(LocalDateTime.from(pInicio), LocalDateTime.from(pFim));
        return new ResponseEntity<List<Item>>(itens, HttpStatus.OK);
    }

    @ExceptionHandler(ItemNaoEncotradoException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public MensagemErro handleItemNaoEncotradoException(HttpServletRequest request, Exception ex) {
        return new MensagemErro(ex.getMessage());
    }

    @ExceptionHandler(FalhaConsultaItemException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public MensagemErro handleFalhaConsultaItemException(HttpServletRequest request, Exception ex) {
        return new MensagemErro(ex.getMessage());
    }
}
