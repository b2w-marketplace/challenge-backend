package br.com.b2w.challengebackend.controllers;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import br.com.b2w.challengebackend.dto.Item;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by anderson on 03/11/16.
 */

@RestControllerAdvice
@RequestMapping("/challenge-backend")
public class ItensController {


    @RequestMapping(value = "/item/", method = RequestMethod.GET, produces = { APPLICATION_JSON_VALUE, APPLICATION_JSON_UTF8_VALUE })
    public ResponseEntity<List<Item>> pesquisarItensProduto(@RequestParam(required = true, name = "begindate") final LocalDateTime inicio, @RequestParam(required = true, name = "finaldate") final LocalDateTime fim) {
        return null;
    }
}
