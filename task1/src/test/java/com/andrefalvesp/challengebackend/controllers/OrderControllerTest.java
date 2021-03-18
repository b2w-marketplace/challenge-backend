package com.andrefalvesp.challengebackend.controllers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.andrefalvesp.challengebackend.domains.OrderBuilder;
import com.andrefalvesp.challengebackend.exception.ExceptionHandler;
import com.andrefalvesp.challengebackend.usecases.CrudOrder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderControllerTest {

  private static final String API_URL = "/challenge-backend/item";
  private static final String BEGINDATE_PARAM = "beginDate";
  private static final String FINALDATE_PARAM = "finalDate";
  private MockMvc mockMvc;
  private final CrudOrder crudOrder = Mockito.mock(CrudOrder.class);
  private final OrderController orderController = new OrderController(crudOrder);
  private final ObjectMapper objectMapper = new ObjectMapper();

  @Before
  public void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(orderController)
        .setControllerAdvice(new ExceptionHandler()).build();
    objectMapper.registerModule(new JavaTimeModule());
  }

  @Test
  public void give_ValidParams_When_FindByDate_Then_Success() throws Exception {

    final var beginDate = "01-01-2020";
    final var finalDate = "05-02-2021";

    final var orderList =
        Stream.of(OrderBuilder.ORDER_CELULAR()).collect(Collectors.toList());

    when(crudOrder.findByDate(any(), any())).thenReturn(orderList);

    final MvcResult mvcResult = mockMvc.perform(get(API_URL)
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .accept(MediaType.APPLICATION_JSON_VALUE)
        .param(BEGINDATE_PARAM, beginDate)
        .param(FINALDATE_PARAM, finalDate)
    ).andReturn();

    final var actual = mvcResult.getResponse().getContentAsString();
    final var expected = objectMapper.writeValueAsString(orderList);

    assertThat(mvcResult.getResponse().getStatus(), is(HttpStatus.OK.value()));
    assertEquals(actual, expected);
    verify(crudOrder, times(1)).findByDate(LocalDate.of(2020, 1, 1),
        LocalDate.of(2021, 2, 5));
  }

  @Test
  public void give_InvalidDataFormat_When_FindByDate_Then_BadRequest() throws Exception {

    final var beginDate = "01-01-2019";
    final var finalDate = "2020-01-10";

    final MvcResult mvcResult = mockMvc.perform(get(API_URL)
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .accept(MediaType.APPLICATION_JSON_VALUE)
        .param(BEGINDATE_PARAM, beginDate)
        .param(FINALDATE_PARAM, finalDate)
    ).andReturn();

    assertThat(mvcResult.getResponse().getStatus(), is(HttpStatus.BAD_REQUEST.value()));
    verify(crudOrder, times(0)).findByDate(any(), any());
  }

  @Test
  public void give_MissingParam_When_FindByDate_Then_BadRequest() throws Exception {

    final var beginDate = "01-01-2019";

    final MvcResult mvcResult = mockMvc.perform(get(API_URL)
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .accept(MediaType.APPLICATION_JSON_VALUE)
        .param(BEGINDATE_PARAM, beginDate)
    ).andReturn();

    assertThat(mvcResult.getResponse().getStatus(), is(HttpStatus.BAD_REQUEST.value()));
    verify(crudOrder, times(0)).findByDate(any(), any());
  }
}