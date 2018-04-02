package br.com.frsiqueira.challengebackend.controller;

import br.com.frsiqueira.challengebackend.config.ItemControllerConfig;
import br.com.frsiqueira.challengebackend.dto.Dimension;
import br.com.frsiqueira.challengebackend.dto.Item;
import br.com.frsiqueira.challengebackend.service.ItemService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ItemControllerConfig.class)
public class ItemControllerTest {

    private Calendar calendar = Calendar.getInstance();
    private Calendar today;
    private Calendar tomorrow;

    @Autowired
    private ItemController itemController;

    @Autowired
    private ItemService itemService;

    @Before
    public void setup() {
        this.today = this.calendar;
        this.calendar.add(Calendar.DATE, 5);
        this.tomorrow = this.calendar;

        this.mockGetItensWithListNotNull();
    }

    @Test
    public void getItensWithListNotNull() {
        Assert.assertEquals(this.mockListWithTwoItens(), this.itemService.getItems(this.today, this.tomorrow));
    }

    @Test
    public void getItensSize() {
        Assert.assertEquals(this.mockListWithTwoItens().size(), this.itemService.getItems(this.today, this.tomorrow).size());
    }

    @Test
    public void getItensWithEmptyList() {
        Calendar calendar = new GregorianCalendar(2013,0,31);
        Assert.assertEquals(0, this.itemService.getItems(calendar, calendar).size());
    }

    private void mockGetItensWithListNotNull() {
        when(this.itemService.getItems(this.today, this.tomorrow))
                .thenReturn(this.mockListWithTwoItens());
    }

    private List<Item> mockListWithTwoItens(){
        return Arrays.asList(
                new Item(
                        "Macbook pro",
                        "1",
                        today,
                        new Dimension(
                                10.0f,
                                10.0f,
                                11.0f,
                                11.0f
                        )),
                new Item(
                        "Dell xps",
                        "2",
                        today,
                        new Dimension(11.0f,
                                12.5f,
                                13.0f,
                                13.0f))
        );
    }
}
