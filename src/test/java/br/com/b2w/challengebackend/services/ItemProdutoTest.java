package br.com.b2w.challengebackend.services;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.b2w.challengebackend.dto.Dimensao;
import br.com.b2w.challengebackend.dto.Item;

/**
 * Created by anderson on 03/11/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemProdutoTest {
    private static final String URL_LISTA_ITEM_PRODUTOS = "http://www.mocky.io/v2/5817803a1000007d01cc7fc9";

    @Autowired
    ItemProdutoService service;

    @MockBean
    RestTemplate rest;

    @Test
    public void deveraRetornarItemProdutoPorDataInicioEDataFim() {
        BDDMockito.given(this.rest.getForEntity(URL_LISTA_ITEM_PRODUTOS, Item[].class)).willReturn(this.retornoMock());

        LocalDateTime inicio = LocalDateTime.of(2016, 10, 1, 0, 0, 0, 0);
        LocalDateTime fim = LocalDateTime.of(2016, 10, 31, 0, 0, 0, 0);

        List itens = this.service.consultarItemProduto(inicio, fim);

        Assertions.assertThat(itens).isEqualTo(this.resposta());
    }

    private ResponseEntity<Item[]> retornoMock() {
        Item[] itens = new Item[2];
        LocalDateTime data = LocalDateTime.of(2016, 10, 1, 14, 30, 37, 40);
        Dimensao dimensao = new Dimensao();
        dimensao.setAltura(Double.valueOf(10.5D));
        dimensao.setComprimento(Double.valueOf(10.5D));
        dimensao.setLargura(Double.valueOf(10.5D));
        dimensao.setPeso(Double.valueOf(10.5D));
        Item item = new Item();
        item.setNome("Celular");
        item.setCodigo(Long.valueOf(1L));
        item.setData(data);
        item.setDimensao(dimensao);
        itens[0] = item;
        item = new Item();
        item.setNome("Xbox");
        item.setCodigo(Long.valueOf(2L));
        item.setData(data);
        item.setDimensao(dimensao);
        itens[1] = item;
        return new ResponseEntity(itens, HttpStatus.OK);
    }

    private List<Item> resposta() {
        ArrayList itens = new ArrayList();
        LocalDateTime data = LocalDateTime.of(2016, 10, 1, 14, 30, 37, 40);
        Dimensao dimensao = new Dimensao();
        dimensao.setAltura(Double.valueOf(10.5D));
        dimensao.setComprimento(Double.valueOf(10.5D));
        dimensao.setLargura(Double.valueOf(10.5D));
        dimensao.setPeso(Double.valueOf(10.5D));
        Item item = new Item();
        item.setNome("Celular");
        item.setCodigo(Long.valueOf(1L));
        item.setData(data);
        item.setDimensao(dimensao);
        itens.add(item);
        item = new Item();
        item.setNome("Xbox");
        item.setCodigo(Long.valueOf(2L));
        item.setData(data);
        item.setDimensao(dimensao);
        itens.add(item);
        return itens;
    }
}

