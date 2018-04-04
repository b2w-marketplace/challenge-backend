package br.com.b2wmarketplace.challengebackend.controller;

import br.com.b2wmarketplace.challengebackend.model.Product;
import br.com.b2wmarketplace.challengebackend.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/challenge-backend")
public class ChallengeBackendController {

    @Autowired
    private ApiService service;

    @GetMapping("/item")
    public List<Product> getItems(@RequestParam("begindate") LocalDate beginDate, @RequestParam("finaldate") LocalDate finalDate) {

        return service.filter(beginDate, finalDate);

    }

}
