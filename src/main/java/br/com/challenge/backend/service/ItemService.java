package br.com.challenge.backend.service;

import br.com.challenge.backend.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private Environment environment;

    @Autowired
    private RestTemplate restTemplate;


    public List<Item> findItems(){
        String uri = environment.getProperty("service.item.uri");
        ResponseEntity<List<Item>> rateResponse =
                restTemplate.exchange(uri,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Item>>() {
                        });
        return rateResponse.getBody();
    }
}
