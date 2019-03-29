package com.b2w.taskone.web.rest;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.b2w.taskone.service.ItemService;
import com.b2w.taskone.web.dto.ItemDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/challenge-backend")
public class ItemResource {

    @Autowired
    ItemService itemService;

    @GetMapping("/item")
    public ResponseEntity getItens(@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date begindate,
            @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date finaldate) {

        //converte as datas passadas como parâmetro para começo do dia na data de inicio e final do dia na data de fim        
        Instant beginInstant = begindate.toInstant();
        ZonedDateTime zdtBegin = ZonedDateTime.ofInstant(beginInstant, ZoneOffset.UTC);
        zdtBegin = zdtBegin.toLocalDate().atStartOfDay(ZoneOffset.UTC);
        Instant beginInstantFilter = zdtBegin.toInstant();

        Instant finalInstant = finaldate.toInstant();
        ZonedDateTime zdtFinal = ZonedDateTime.ofInstant(finalInstant, ZoneOffset.UTC);
        zdtFinal = zdtFinal.toLocalDate().atTime(23, 59, 59).atZone(ZoneOffset.UTC);
        Instant finalInstantFilter = zdtFinal.toInstant();      

        List<ItemDTO> itens = itemService.getAllItens();
      
        List<ItemDTO> result = itens.stream().filter(
                item -> item.getDate().isAfter(beginInstantFilter) && item.getDate().isBefore(finalInstantFilter))
                .collect(Collectors.toList());      

        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok().headers(headers).body(result);

    }

}