package com.b2w.desafiob2w.util;
/*
    Tiago Iwamoto
    tiago.iwamoto@gmail.com
    System Analyst
    MBA Business Intelligence
*/

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("all")
public class B2wProperties {

    @Value("${b2w.url.products}")
    private String urlProducts;

    public String getUrlProducts() {
        return urlProducts;
    }

    public void setUrlProducts(String urlProducts) {
        this.urlProducts = urlProducts;
    }
}
