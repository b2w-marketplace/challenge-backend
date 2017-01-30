package br.com.munieri.domain.item.service;

import br.com.munieri.domain.item.Item;
import br.com.munieri.domain.item.ItemNotFound;
import br.com.munieri.infrastructure.repository.dimension.DimensionEntity;
import br.com.munieri.infrastructure.repository.item.ItemEntity;
import br.com.munieri.infrastructure.repository.item.ItemRepository;
import br.com.munieri.util.DateUtil;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

public class ItemServiceTest {

    @InjectMocks
    ItemService service;

    @Mock
    ItemRepository repository;

    @BeforeMethod
    public void init(){
        service = new ItemServiceImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_return_one_valid_item() throws ParseException {

        Date beginDate = DateUtil.parse("01-10-2016", DateUtil.SIMPLE_PATTERN);
        Date finalDate = DateUtil.parse("01-10-2016", DateUtil.SIMPLE_PATTERN);

        ItemEntity mock = new ItemEntity("Celular", 1L, DateUtil.parse("2016-10-01", DateUtil.SIMPLE_PATTERN),
                new DimensionEntity(10.5, 10.5, 10.5, 10.5));
        mock.setId(1L);
        when(repository.findByInterval(beginDate, finalDate)).thenReturn(Arrays.asList(mock));

        List<Item> items = service.findByInterval(beginDate, finalDate);

        assertEquals(items.get(0).name(), "Celular");

    }

    @Test(expectedExceptions = ItemNotFound.class)
    public void should_throw_exception_when_item_not_found() throws ParseException {

        Date beginDate = DateUtil.parse("01-10-2017", DateUtil.SIMPLE_PATTERN);
        Date finalDate = DateUtil.parse("01-10-2017", DateUtil.SIMPLE_PATTERN);

        when(repository.findByInterval(beginDate, finalDate)).thenReturn(new ArrayList<>());

        service.findByInterval(beginDate, finalDate);

    }
}
