package br.com.b2w.challengebackend.services.impl;

import br.com.b2w.challengebackend.exception.FalhaConsultaItemException;
import br.com.b2w.challengebackend.exception.ItemNaoEncotradoException;
import br.com.b2w.challengebackend.services.ItensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import br.com.b2w.challengebackend.dto.Item;

/**
 * Created by anderson on 03/11/16.
 */
@Service
public class ItensImpl implements ItensService {

    private static final String URL_LISTA_ITEM_PRODUTOS = "http://www.mocky.io/v2/5817803a1000007d01cc7fc9";

    @Autowired
    RestTemplate restTemplate;

    public List<Item> consultarItemProduto(LocalDateTime inicio, LocalDateTime fim) throws ItemNaoEncotradoException, FalhaConsultaItemException {

        ResponseEntity response = this.restTemplate.getForEntity(URL_LISTA_ITEM_PRODUTOS, Item[].class);

        if (!(HttpStatus.OK.equals(response.getStatusCode()))) {
            throw new FalhaConsultaItemException();
        }

        List<Item> itens = Arrays.asList((Item[])response.getBody());

        List<Item> itensFiltrados = itens.stream().filter((item) -> {
            return (inicio.isEqual(item.getData()) || inicio.isBefore(item.getData())) && (fim.isEqual(item.getData()) || fim.isAfter(item.getData()));
        }).collect(Collectors.toList());

        if (itensFiltrados.isEmpty()) {
            throw new ItemNaoEncotradoException();
        }

        return itensFiltrados;

    }
}
