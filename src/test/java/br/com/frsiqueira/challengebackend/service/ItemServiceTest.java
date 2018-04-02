package br.com.frsiqueira.challengebackend.service;

import br.com.frsiqueira.challengebackend.config.ItemServiceConfig;
import br.com.frsiqueira.challengebackend.dto.Dimension;
import br.com.frsiqueira.challengebackend.dto.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ItemServiceConfig.class)
public class ItemServiceTest {

    private Calendar cal1 = Calendar.getInstance();
    private Calendar cal2 = Calendar.getInstance();
    private Calendar cal3 = Calendar.getInstance();

    private static final String URL = "http://www.mocky.io/v2/5817803a1000007d01cc7fc9";

    @Autowired
    private ItemService itemService;

    @Autowired
    private RestTemplate restTemplate;

    @Before
    public void setup() {
        this.cal2.add(Calendar.DATE, 5);
        this.cal3.add(Calendar.DATE, 7);

        this.mockRestTemplate(URL);
    }

    @Test
    public void getItemsWithListNotNull() {
        Assert.assertEquals(this.mockListWithThreeItems(), this.itemService.getItems(cal1, cal2));
    }

    @Test
    public void getItemsWithoutItems() {

    }

    private void mockRestTemplate(String url) {
        Mockito.when(
                this.restTemplate.getForObject(URL, Item[].class))
                .thenReturn(this.mockArrayWithThreeItems());
    }

    private Item[] mockArrayWithThreeItems(){
        Item[] arrayItem = {
                new Item(
                        "Macbook pro",
                        "1",
                        cal1,
                        new Dimension(
                                10.0f,
                                10.0f,
                                11.0f,
                                11.0f
                        )),
                new Item(
                        "Dell xps",
                        "2",
                        cal2,
                        new Dimension(
                                11.0f,
                                12.5f,
                                13.0f,
                                13.0f)),
                new Item(
                        "Dell xps",
                        "3",
                        cal3,
                        new Dimension(
                                11.0f,
                                12.5f,
                                13.0f,
                                13.0f))
        };

        return arrayItem;
    }

    private List<Item> mockListWithThreeItems(){
        return Arrays.asList(
                new Item(
                        "Macbook pro",
                        "1",
                        cal1,
                        new Dimension(
                                10.0f,
                                10.0f,
                                11.0f,
                                11.0f
                        )),
                new Item(
                        "Dell xps",
                        "2",
                        cal2,
                        new Dimension(11.0f,
                                12.5f,
                                13.0f,
                                13.0f))
        );
    }
}
