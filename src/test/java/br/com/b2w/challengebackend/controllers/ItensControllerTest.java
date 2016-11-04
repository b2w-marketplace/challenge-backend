package br.com.b2w.challengebackend.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.b2w.challengebackend.factory.TestFactory;
import br.com.b2w.challengebackend.dto.Item;
import br.com.b2w.challengebackend.services.ItensService;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by anderson on 03/11/16.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ItensController.class)
public class ItensControllerTest {

    private static final String URL_LISTA_ITEM_PRODUTOS = "http://www.mocky.io/v2/5817803a1000007d01cc7fc9";

    private static final String URL = "/challenge-backend/item/";

    private static final DateTimeFormatter formata = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private LocalDate inicio;
    private LocalDate fim;

    @Autowired
    MockMvc mvc;

    @MockBean
    RestTemplate restTemplate;

    @MockBean
    ItensService service;

    @Before
    public void setup() {
        inicio = LocalDate.of(2016, 10, 01);
        fim = LocalDate.of(2016, 10, 31);

        given(this.restTemplate.getForEntity(URL_LISTA_ITEM_PRODUTOS, Item[].class)).willReturn(TestFactory.criarRetornoMockArrayItem());

        LocalDateTime pInicio = LocalDateTime.of(inicio.getYear(), inicio.getMonth(), inicio.getDayOfMonth(), 0, 0, 0, 0);
        LocalDateTime pFim = LocalDateTime.of(fim.getYear(), fim.getMonth(), fim.getDayOfMonth(), 0, 0, 0, 0);

        given(this.service.consultarItemProduto(pInicio, pFim)).willReturn(TestFactory.criarListaItem());
    }

    @Test
    public void deveraRetornarItensPorDataInicioEDataFim() throws Exception {

        this.mvc.perform(
                get(URL)
                        .param("begindate", inicio.format(formata))
                        .param("finaldate", fim.format(formata))
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$[0].name").value("Celular"))
                .andExpect(jsonPath("$[0].code").value("1"))
                .andExpect(jsonPath("$[0].date").value("2016-10-01T14:30:37.000Z"))
                .andExpect(jsonPath("$[0].dimension.weight").value("10.5"))
                .andExpect(jsonPath("$[0].dimension.height").value("10.5"))
                .andExpect(jsonPath("$[0].dimension.width").value("10.5"))
                .andExpect(jsonPath("$[0].dimension.length").value("10.5"))
                .andExpect(jsonPath("$[1].name").value("Xbox"))
                .andExpect(jsonPath("$[1].code").value("2"))
                .andExpect(jsonPath("$[1].date").value("2016-10-01T14:30:37.000Z"))
                .andExpect(jsonPath("$[1].dimension.weight").value("10.5"))
                .andExpect(jsonPath("$[1].dimension.height").value("10.5"))
                .andExpect(jsonPath("$[1].dimension.width").value("10.5"))
                .andExpect(jsonPath("$[1].dimension.length").value("10.5"));
    }
}
