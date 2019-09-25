package com.herokuapp.zeversion.task1.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ChallengeBackendController {

    @GetMapping("/challenge-backend/item")
    public List<?> getItens(@RequestParam("begindate") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate begindate,
                            @RequestParam("finaldate") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate finaldate) {
        return null;
    }
}
