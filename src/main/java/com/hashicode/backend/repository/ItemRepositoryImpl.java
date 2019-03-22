package com.hashicode.backend.repository;

import com.hashicode.backend.model.Item;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

/**
 * Repositório de itens que obtem os mesmos via uma api
 *
 * @author takahashi
 */
@Repository
public class ItemRepositoryImpl implements ItemRepository{

    private RestTemplate restTemplate = new RestTemplate();

    public List<Item> getItens(){
        ResponseEntity<List<Item>> result = restTemplate.exchange(System.getProperty("orderURL"), HttpMethod.GET, null, new ParameterizedTypeReference<List<Item>>(){});
        List<Item> itens = result.getBody();
        if(CollectionUtils.isNotEmpty(itens)){
            return itens;
        }
        return Collections.emptyList();
    }

}
