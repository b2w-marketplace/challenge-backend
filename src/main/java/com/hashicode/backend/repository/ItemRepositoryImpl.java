package com.hashicode.backend.repository;

import com.google.common.base.Preconditions;
import com.hashicode.backend.model.Item;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

import static com.hashicode.backend.Constants.MSG_NULL_ORDER_URL;
import static com.hashicode.backend.Constants.ORDER_URL;

/**
 * Repositório de itens que obtem os mesmos via uma api
 *
 * @author takahashi
 */
@Repository
public class ItemRepositoryImpl implements ItemRepository{

    @Autowired
    private MessageSource messageSource;

    private RestTemplate restTemplate = new RestTemplate();

    public List<Item> getItens(){
        String orderURL = System.getProperty(ORDER_URL);
        Preconditions.checkArgument(orderURL!=null && !orderURL.isEmpty(), messageSource.getMessage(MSG_NULL_ORDER_URL, null, Locale.getDefault()));
        ResponseEntity<List<Item>> result = restTemplate.exchange(orderURL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Item>>(){});
        List<Item> itens = result.getBody();
        if(CollectionUtils.isNotEmpty(itens)){
            return itens;
        }
        return Collections.emptyList();
    }

}
