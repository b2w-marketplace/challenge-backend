package com.b2w.desafiob2w.controller;
/*
    Tiago Iwamoto
    tiago.iwamoto@gmail.com
    System Analyst
    MBA Business Intelligence
*/

import com.b2w.desafiob2w.dto.B2wDto;
import com.b2w.desafiob2w.entity.Product;
import com.b2w.desafiob2w.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rotas de acesso a aplicação
 */
@RestController
@RequestMapping(value = "/item")
public class ProductController {

    /**
     * Tornando o serviço de produto disponivel para a controller
     */
    @Autowired
    private ProductService productService;

    /**
     * Criando rota que recebe dois parametros de forma mais elegante que a tradicional ?param1=1&para2=2
     * @param beginDate
     * @param finalDate
     * @return
     */
    @GetMapping(value = "/{beginDate}/{finalDate}")
    public ResponseEntity<B2wDto<List<Product>>> productsByDateBeautyUrl(@PathVariable(name = "beginDate") String beginDate,
                                                                         @PathVariable(name = "finalDate") String finalDate){
        B2wDto<List<Product>> b2wDto = productService.findProducts(beginDate, finalDate);
        return new ResponseEntity<>(b2wDto, HttpStatus.OK);
    }

    /**
     * Criando rota que recebe 2 parametros
     * @param beginDate
     * @param finalDate
     * @return
     */
    @GetMapping
    public ResponseEntity<B2wDto<List<Product>>> productsByDate(@RequestParam String beginDate,
                                                                @RequestParam String finalDate){
        B2wDto<List<Product>> b2wDto = productService.findProducts(beginDate, finalDate);
        return new ResponseEntity<>(b2wDto, HttpStatus.OK);
    }

}
