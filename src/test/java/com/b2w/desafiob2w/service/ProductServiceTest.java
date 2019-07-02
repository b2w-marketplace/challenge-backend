package com.b2w.desafiob2w.service;

import com.b2w.desafiob2w.dto.B2wDto;
import com.b2w.desafiob2w.entity.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/*
    Tiago Iwamoto
    tiago.iwamoto@gmail.com
    System Analyst
    MBA Business Intelligence
*/

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    public void findProducts() {
        B2wDto<List<Product>> b2wDto = productService.findProducts("2016-08-05", "2016-08-05");
        Assert.assertNotNull(b2wDto);
        Assert.assertNotNull(b2wDto.getObj());
    }
}