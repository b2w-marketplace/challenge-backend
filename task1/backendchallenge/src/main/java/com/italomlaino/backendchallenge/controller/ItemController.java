package com.italomlaino.backendchallenge.controller;

import com.italomlaino.backendchallenge.dto.ItemDto;
import com.italomlaino.backendchallenge.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/challenge-backend")
public class ItemController {

    private static final String DATE_PATTERN = "dd-MM-yyyy";

    private final ItemService service;

    @Autowired
    public ItemController(ItemService itemService) {
        this.service = itemService;
    }

    @GetMapping("/item")
    public List<ItemDto> fetch(
            @RequestParam(name = "begindate", required = false) @DateTimeFormat(pattern = DATE_PATTERN) LocalDate beginDate,
            @RequestParam(name = "finaldate", required = false) @DateTimeFormat(pattern = DATE_PATTERN) LocalDate finalDate) {
        return service.fetch(beginDate, finalDate);
    }
}
