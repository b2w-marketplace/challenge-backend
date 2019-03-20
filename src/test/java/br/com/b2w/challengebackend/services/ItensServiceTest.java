package br.com.b2w.challengebackend.services;

import br.com.b2w.challengebackend.factory.TestFactory;
import br.com.b2w.challengebackend.exception.FalhaConsultaItemException;
import br.com.b2w.challengebackend.exception.ItemNaoEncotradoException;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.BDDMockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

import br.com.b2w.challengebackend.dto.Item;

/**
 * Created by anderson on 03/11/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ItensServiceTest {
    private static final String URL_LISTA_ITEM_PRODUTOS = "http://www.mocky.io/v2/5817803a1000007d01cc7fc9";

    @Autowired
    ItensService service;

    @MockBean
    RestTemplate rest;

    @Test
    public void deveraRetornarItemProdutoPorDataInicioEDataFim() {
        given(this.rest.getForEntity(URL_LISTA_ITEM_PRODUTOS, Item[].class)).willReturn(TestFactory.criarRetornoMockArrayItem());

        LocalDateTime inicio = LocalDateTime.of(2016, 10, 1, 0, 0, 0, 0);
        LocalDateTime fim = LocalDateTime.of(2016, 10, 31, 0, 0, 0, 0);

        Assertions.assertThat(this.service.consultarItemProduto(inicio, fim)).isEqualTo(TestFactory.criarListaItem());
    }

    @Test(expected = ItemNaoEncotradoException.class)
    public void deveraRetornarExcessaoDeResultadoNaoEncontrado() {
        given(this.rest.getForEntity(URL_LISTA_ITEM_PRODUTOS, Item[].class)).willReturn(TestFactory.criarRetornoMockArrayItem());

        LocalDateTime inicio = LocalDateTime.of(2016, 8, 1, 0, 0, 0, 0);
        LocalDateTime fim = LocalDateTime.of(2016, 8, 31, 0, 0, 0, 0);

        this.service.consultarItemProduto(inicio, fim);
    }

    @Test(expected = FalhaConsultaItemException.class)
    public void deveraRetornarRetornarFalhaParaErro301() {
        given(this.rest.getForEntity(URL_LISTA_ITEM_PRODUTOS, Item[].class)).willReturn(new ResponseEntity(HttpStatus.MOVED_PERMANENTLY));

        LocalDateTime inicio = LocalDateTime.of(2016, 10, 1, 0, 0, 0, 0);
        LocalDateTime fim = LocalDateTime.of(2016, 10, 31, 0, 0, 0, 0);

        this.service.consultarItemProduto(inicio, fim);
    }

    @Test(expected = FalhaConsultaItemException.class)
    public void deveraRetornarRetornarFalhaParaErro302() {
        given(this.rest.getForEntity(URL_LISTA_ITEM_PRODUTOS, Item[].class)).willReturn(new ResponseEntity(HttpStatus.FOUND));

        LocalDateTime inicio = LocalDateTime.of(2016, 10, 1, 0, 0, 0, 0);
        LocalDateTime fim = LocalDateTime.of(2016, 10, 31, 0, 0, 0, 0);

        this.service.consultarItemProduto(inicio, fim);
    }

    @Test(expected = FalhaConsultaItemException.class)
    public void deveraRetornarRetornarFalhaParaErro400() {
        given(this.rest.getForEntity(URL_LISTA_ITEM_PRODUTOS, Item[].class)).willReturn(new ResponseEntity(HttpStatus.BAD_REQUEST));

        LocalDateTime inicio = LocalDateTime.of(2016, 10, 1, 0, 0, 0, 0);
        LocalDateTime fim = LocalDateTime.of(2016, 10, 31, 0, 0, 0, 0);

        this.service.consultarItemProduto(inicio, fim);
    }

    @Test(expected = FalhaConsultaItemException.class)
    public void deveraRetornarRetornarFalhaParaErro401() {
        given(this.rest.getForEntity(URL_LISTA_ITEM_PRODUTOS, Item[].class)).willReturn(new ResponseEntity(HttpStatus.UNAUTHORIZED));

        LocalDateTime inicio = LocalDateTime.of(2016, 10, 1, 0, 0, 0, 0);
        LocalDateTime fim = LocalDateTime.of(2016, 10, 31, 0, 0, 0, 0);

        this.service.consultarItemProduto(inicio, fim);
    }

    @Test(expected = FalhaConsultaItemException.class)
    public void deveraRetornarRetornarFalhaParaErro403() {
        given(this.rest.getForEntity(URL_LISTA_ITEM_PRODUTOS, Item[].class)).willReturn(new ResponseEntity(HttpStatus.FORBIDDEN));

        LocalDateTime inicio = LocalDateTime.of(2016, 10, 1, 0, 0, 0, 0);
        LocalDateTime fim = LocalDateTime.of(2016, 10, 31, 0, 0, 0, 0);
        this.service.consultarItemProduto(inicio, fim);
    }

    @Test(expected = FalhaConsultaItemException.class)
    public void deveraRetornarRetornarFalhaParaErro404() {
        given(this.rest.getForEntity(URL_LISTA_ITEM_PRODUTOS, Item[].class)).willReturn(new ResponseEntity(HttpStatus.NOT_FOUND));

        LocalDateTime inicio = LocalDateTime.of(2016, 10, 1, 0, 0, 0, 0);
        LocalDateTime fim = LocalDateTime.of(2016, 10, 31, 0, 0, 0, 0);

        this.service.consultarItemProduto(inicio, fim);
    }

    @Test(expected = FalhaConsultaItemException.class)
    public void deveraRetornarRetornarFalhaParaErro500() {
        given(this.rest.getForEntity(URL_LISTA_ITEM_PRODUTOS, Item[].class)).willReturn(new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR));

        LocalDateTime inicio = LocalDateTime.of(2016, 10, 1, 0, 0, 0, 0);
        LocalDateTime fim = LocalDateTime.of(2016, 10, 31, 0, 0, 0, 0);

        this.service.consultarItemProduto(inicio, fim);
    }

    @Test(expected = FalhaConsultaItemException.class)
    public void deveraRetornarRetornarFalhaParaErro502() {
        given(this.rest.getForEntity(URL_LISTA_ITEM_PRODUTOS, Item[].class)).willReturn(new ResponseEntity(HttpStatus.BAD_GATEWAY));

        LocalDateTime inicio = LocalDateTime.of(2016, 10, 1, 0, 0, 0, 0);
        LocalDateTime fim = LocalDateTime.of(2016, 10, 31, 0, 0, 0, 0);

        this.service.consultarItemProduto(inicio, fim);
    }

}

