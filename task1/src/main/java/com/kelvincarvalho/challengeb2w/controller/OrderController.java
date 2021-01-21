package com.kelvincarvalho.challengeb2w.controller;

import com.kelvincarvalho.challengeb2w.model.OrderDTO;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/challenge-backend", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

    private final String patternDate = "dd-MM-yyyy";

    @GetMapping(value = "/item")
    public List<OrderDTO> listOrder(@RequestParam(name = "begindate") @DateTimeFormat(pattern = patternDate) LocalDate beginDate,
                                    @RequestParam(name = "finaldate") @DateTimeFormat(pattern = patternDate) LocalDate finalDate) {
        return null;
    }

}
