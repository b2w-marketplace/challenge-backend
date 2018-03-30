package br.com.challenge.backend.service;

import br.com.challenge.backend.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    @Autowired
    private Environment environment;

    @Autowired
    private RestTemplate restTemplate;


    public List<Item> findItems(String beginDate, String finalDate) {
        List<Item> items = findAllItems();
        LocalDateTime begin = formatDate(beginDate);
        LocalDateTime end = formatDate(finalDate);
        items = filterItems(items, begin, end);
        return items;
    }

    private LocalDateTime formatDate(String beginDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = null;
        try {
            date = LocalDate.parse(beginDate, formatter);
        } catch (DateTimeParseException e) {
            throw new DateTimeParseException(e.getMessage(), e.getParsedString(), 0);
        }
        return LocalDateTime.of(date, LocalTime.MIDNIGHT);
    }

    private List<Item> filterItems(List<Item> items, LocalDateTime beginDate, LocalDateTime finalDate) {
        return items.stream().
                filter((i) -> i.getDate().isAfter(beginDate) &&
                        i.getDate().isBefore(finalDate))
                .collect(Collectors.toList());
    }

    private List<Item> findAllItems() {
        String uri = environment.getProperty("service.item.uri");
        ResponseEntity<List<Item>> rateResponse =
                restTemplate.exchange(uri,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Item>>() {
                        });
        return rateResponse.getBody();
    }


}
