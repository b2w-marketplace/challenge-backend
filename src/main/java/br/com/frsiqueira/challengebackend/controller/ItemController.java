package br.com.frsiqueira.challengebackend.controller;


import br.com.frsiqueira.challengebackend.dto.Item;
import br.com.frsiqueira.challengebackend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<Item> getItem(
            @PathVariable("begindate") Calendar beginDate,
            @PathVariable("finaldate") Calendar finalDate) {

        return this.itemService.getItens(beginDate, finalDate);

    }

}
