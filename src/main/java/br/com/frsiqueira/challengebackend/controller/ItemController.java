package br.com.frsiqueira.challengebackend.controller;


import br.com.frsiqueira.challengebackend.dto.Item;
import br.com.frsiqueira.challengebackend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<Item> getItems(
            @DateTimeFormat(pattern = "dd-MM-yyyy") @RequestParam("begindate") Calendar beginDate,
            @DateTimeFormat(pattern = "dd-MM-yyyy") @RequestParam("finaldate") Calendar finalDate) {

        return this.itemService.getItems(beginDate, finalDate);

    }

}
