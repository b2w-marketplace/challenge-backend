package com.b2w.challengebackend.controller;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.b2w.challengebackend.modelo.Item;
import com.b2w.challengebackend.service.ItemService;

@RestController
@RequestMapping("/challenge-backend")
public class ItemController {

	@Autowired
    ItemService itemService;

    @GetMapping("/item")
    public ResponseEntity getItens(@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date begindate,
            @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date finaldate) {
         
    	//Formatação data inicial
        Instant instantInicial = begindate.toInstant();
        ZonedDateTime zoneInicial = ZonedDateTime.ofInstant(instantInicial, ZoneOffset.UTC);
        zoneInicial = zoneInicial.toLocalDate().atStartOfDay(ZoneOffset.UTC);
        Instant dataInicio = zoneInicial.toInstant();
        
        //Formatação data final
        Instant instantFinal = finaldate.toInstant();
        ZonedDateTime zoneFinal = ZonedDateTime.ofInstant(instantFinal, ZoneOffset.UTC);
        zoneFinal = zoneFinal.toLocalDate().atTime(23, 59, 59).atZone(ZoneOffset.UTC);
        Instant dataFim = zoneFinal.toInstant();      

        List<Item> itens = itemService.getAllItens();
      
        List<Item> result = itens.stream().filter(
                item -> item.getDate().isAfter(dataInicio) && item.getDate().isBefore(dataFim))
                .collect(Collectors.toList());      

        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok().headers(headers).body(result);
    }
}