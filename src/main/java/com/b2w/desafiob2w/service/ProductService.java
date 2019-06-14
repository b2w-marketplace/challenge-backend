package com.b2w.desafiob2w.service;
/*
    Tiago Iwamoto
    tiago.iwamoto@gmail.com
    System Analyst
    MBA Business Intelligence

    Adicionada a regra de negocio da aplicacao
*/

import com.b2w.desafiob2w.dto.B2wDto;
import com.b2w.desafiob2w.entity.Product;
import com.b2w.desafiob2w.enums.B2wMessages;
import com.b2w.desafiob2w.util.B2wProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Component
public class ProductService {

    @Autowired
    private B2wProperties b2wProperties;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public B2wDto<List<Product>> findProducts(String beginDate, String finalDate){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        RestTemplate restTemplate = new RestTemplate();
        List<Product> products = null;
        List<Product> productsOrdered = new LinkedList<>();
        ResponseEntity<List<Product>> request = null;

        try {
            //Definindo a hora inicial para meia noite que é o inicio do dia informado
            Date dataInicio = sdf.parse(beginDate + " 00:00:00");
            //Definindo hora final para 23:59:59 que é o último horario do dia informado
            Date dataFim = sdf.parse(finalDate + " 23:59:59");
            request = restTemplate.exchange(
                    b2wProperties.getUrlProducts(),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Product>>() {
                    });
            if (request.getStatusCode() == HttpStatus.OK) {
                products = request.getBody();
                products.sort(Comparator.comparing(Product::getDate));
                products.stream().forEach(product -> {
                    //Verificando se a data do produto é menor que data final informada
                    if(product.getDate().getTime() < dataFim.getTime()){
                        //Verificando se a data do produto é maior que a data inicial informada
                        if(product.getDate().getTime() > dataInicio.getTime()){
                            productsOrdered.add(product);
                        }
                    }
                });
            }

            if (productsOrdered == null) {
                return new B2wDto<>(200, B2wMessages.NULL_OBJECT.get());
            } else if (productsOrdered.size() == 0) {
                return new B2wDto<>(200, B2wMessages.EMPTY_LIST.get());
            } else {
                return new B2wDto<>(200, B2wMessages.RECOVERED.get(), productsOrdered);
            }
        }catch (Exception e){
            logger.error(getClass().getSimpleName(), e.getMessage());
            return new B2wDto<>(200, B2wMessages.EX.get());
        }
    }


}
