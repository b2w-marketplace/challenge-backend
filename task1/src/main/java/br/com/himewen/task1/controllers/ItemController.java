package br.com.himewen.task1.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import br.com.himewen.task1.models.Item;
import br.com.himewen.task1.repository.IItemRepository;
import br.com.himewen.task1.repository.ItemRepository;

/**
 * ItemController
 */
@Controller
public class ItemController {

    // item repository with search functions
    private IItemRepository itemRepository;

    /**
     * Default constructor
     * Get API Data and parse JSON to itens and create ItemRepository
     */
    public ItemController() {
        List<Item> itens = new ArrayList<>();
        String response = getApiData("http://www.mocky.io/v2/5817803a1000007d01cc7fc9");
        ObjectMapper mapper = new ObjectMapper();
        try {
            itens = mapper.readValue(response,
                    mapper.getTypeFactory().constructParametricType(List.class, Item.class));
        } catch (IOException e) {
            e.printStackTrace();
        }

        itemRepository = new ItemRepository(itens);
    }

    /**
     * Get API Data
     * Based on URL, get a Item list and returns the response
     * @param url The URL to perform GET request
     * @return The response body
     */
    private String getApiData(String url) {
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "*/*");
        HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
        ResponseEntity<String> responseEntity = rest.exchange(url, HttpMethod.GET, requestEntity, String.class);
        return responseEntity.getBody();
    }

    /**
     * Search itens based on attributes
     * @param name The item name
     * @param code The item code
     * @param beginDate A begin date for date filters 
     * @param finalDate A final date for date filters
     * @return A list of itens
     */
    @GetMapping("/challenge-backend/item")
    @ResponseBody
    public List<Item> serachItems(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "code", required = false) String code,
            @RequestParam(name = "begindate", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate beginDate,
            @RequestParam(name = "finaldate", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate finalDate) {

        if (code != null)
            return itemRepository.findByCode(code);
        
        if (name != null)
            return itemRepository.findByName(name);

        if (beginDate != null && finalDate != null) {
            Date begindate = Date.from(beginDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            Date finaldate = Date.from(finalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            return itemRepository.findByDate(begindate, finaldate);
        }
            
        return itemRepository.getItens();
    }
    
}