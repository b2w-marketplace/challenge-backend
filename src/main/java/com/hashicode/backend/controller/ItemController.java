package com.hashicode.backend.controller;

import com.hashicode.backend.model.Item;
import com.hashicode.backend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * Controller principal da aplicação
 * @author takahashi
 */
@RestController
@RequestMapping(value = "/challenge-backend")
public class ItemController {

    @Autowired
    private ItemService service;

    /**
     * Endpoint que retorna os itens dado os parametros begindate e finaldate.
     *
     * @param start
     * @param end
     * @return
     */
    @RequestMapping(value = "/item", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> getItensBetween(@RequestParam(value = "begindate")LocalDate start, @RequestParam(value="finaldate") LocalDate end){
        return service.getItensBetween(start, end);
    }


}
