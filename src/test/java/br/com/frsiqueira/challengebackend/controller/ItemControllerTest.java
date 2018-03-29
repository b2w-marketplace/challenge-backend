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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ItemControllerConfig.class)
public class ItemControllerTest {

    private Calendar calendar = Calendar.getInstance();
    private Calendar now;
    private Calendar tomorrow;

    @Autowired
    private ItemController itemController;

    @Autowired
    private ItemService itemService;

    @Before
    public void setup() {
        this.mockGetItensWithListNotNull();
    }

    @Test
    public void getItensWithListNotNull() {
        Assert.assertEquals(this.mockListWithTwoItens(), this.itemService.getItens(now, tomorrow));
    }

    @Test
    public void getItensSize() {
        Assert.assertEquals(this.mockListWithTwoItens().size(), this.itemService.getItens(now, tomorrow).size());
    }

    @Test
    public void getItensWithEmptyList() {
        Assert.assertEquals(new ArrayList<Item>(), this.itemService.getItens(now, now).size());
    }

    private void mockGetItensWithListNotNull() {
        this.now = this.calendar;
        this.calendar.add(Calendar.DATE, 1);
        this.tomorrow = this.calendar;

        when(
                this.itemService
                        .getItens(now, tomorrow))
                .thenReturn(this.mockListWithTwoItens());
    }

    public List<Item> mockListWithTwoItens(){
        return Arrays.asList(
                new Item(
                        "Macbook pro",
                        "1",
                        now,
                        new Dimension(
                                new BigDecimal(10.0),
                                new BigDecimal(10.0),
                                new BigDecimal(11.0),
                                new BigDecimal(11.0)
                        )),
                new Item(
                        "Dell xps",
                        "2",
                        tomorrow,
                        new Dimension(new BigDecimal(11.0),
                                new BigDecimal(12.5),
                                new BigDecimal(13.0),
                                new BigDecimal(13.0)))
        );
    }
}
