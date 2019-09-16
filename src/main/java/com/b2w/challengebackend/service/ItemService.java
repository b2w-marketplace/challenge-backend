package com.b2w.challengebackend.service;

import java.util.List;

import com.b2w.challengebackend.modelo.Item;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ItemService {

    RestTemplate restTemplate;
    
    public ItemService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Item> getAllItens() {
        ResponseEntity<List<Item>> response = restTemplate.exchange(
                "http://www.mocky.io/v2/5817803a1000007d01cc7fc9", HttpMethod.GET, null,
                new ParameterizedTypeReference <List<Item>>() {
                });
        List<Item> item = response.getBody();
        return item;
    }

}