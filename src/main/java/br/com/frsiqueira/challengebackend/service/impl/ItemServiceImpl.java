package br.com.frsiqueira.challengebackend.service.impl;

import br.com.frsiqueira.challengebackend.dto.Item;
import br.com.frsiqueira.challengebackend.service.ItemService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private static final String URL = "http://www.mocky.io/v2/5817803a1000007d01cc7fc9";

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger logger = LogManager.getLogger("ItemServiceImpl");


    @Override
    public List<Item> getItems(Calendar beginDate, Calendar finalDate) {
        return Arrays
                .stream(
                        this.restTemplate.getForObject(URL, Item[].class))
                .filter(item ->
                        (item.getDate().after(beginDate)
                                || item.getDate().equals(beginDate))
                                && (item.getDate().before(this.getCalendarWithMaximumTime(finalDate))
                                || item.getDate().equals(this.getCalendarWithMaximumTime(finalDate))))
                .collect(Collectors.toList());
    }

    private Calendar getCalendarWithMaximumTime(Calendar cal) {
        Calendar calCopy = (Calendar) cal.clone();
        calCopy.set(Calendar.HOUR_OF_DAY, calCopy.getMaximum(Calendar.HOUR_OF_DAY));
        calCopy.set(Calendar.MINUTE,      calCopy.getMaximum(Calendar.MINUTE));
        calCopy.set(Calendar.SECOND,      calCopy.getMaximum(Calendar.SECOND));
        calCopy.set(Calendar.MILLISECOND, calCopy.getMaximum(Calendar.MILLISECOND));

        return calCopy;
    }

}
