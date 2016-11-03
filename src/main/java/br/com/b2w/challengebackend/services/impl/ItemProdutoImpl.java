package br.com.b2w.challengebackend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import br.com.b2w.challengebackend.dto.Item;
import br.com.b2w.challengebackend.services.ItemProdutoService;

/**
 * Created by anderson on 03/11/16.
 */
@Service
public class ItemProdutoImpl implements ItemProdutoService {

    private static final String URL_LISTA_ITEM_PRODUTOS = "http://www.mocky.io/v2/5817803a1000007d01cc7fc9";

    @Autowired
    RestTemplate rest;

    public List<Item> consultarItemProduto(LocalDateTime inicio, LocalDateTime fim) {

        ResponseEntity response = this.rest.getForEntity(URL_LISTA_ITEM_PRODUTOS, Item[].class);

        List<Item> itens = Arrays.asList((Item[])response.getBody());

        return (List)itens.stream().filter((item) -> {
            return (inicio.isEqual(item.getData()) || inicio.isBefore(item.getData())) && (fim.isEqual(item.getData()) || fim.isAfter(item.getData()));
        }).collect(Collectors.toList());

    }
}
