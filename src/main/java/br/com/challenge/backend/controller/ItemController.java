package br.com.challenge.backend.controller;

import br.com.challenge.backend.model.Item;
import br.com.challenge.backend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<Item> findItems(@RequestParam("begindate") String beginDate, @RequestParam("finaldate") String finalDate) {
        return itemService.findItems(beginDate, finalDate);
    }
}
