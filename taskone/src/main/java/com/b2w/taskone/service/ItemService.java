package com.b2w.taskone.service;

import java.util.List;

import com.b2w.taskone.web.dto.ItemDTO;

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

    public List<ItemDTO> getAllItens() {
        ResponseEntity<List<ItemDTO>> response = restTemplate.exchange(
                "http://www.mocky.io/v2/5817803a1000007d01cc7fc9", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<ItemDTO>>() {
                });
        List<ItemDTO> itens = response.getBody();
        return itens;
    }

}