package com.b2w.taskone.web.rest;

import java.util.List;

import com.b2w.taskone.service.ItemService;
import com.b2w.taskone.web.dto.ItemDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/challenge-backend")
public class ItemResource{

    @Autowired
    ItemService itemService;

    @GetMapping("/item")
    public ResponseEntity getItens(){
        
        List<ItemDTO> itens= itemService.getAllItens();        

        return null;
    }

}