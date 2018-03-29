package br.com.frsiqueira.challengebackend.config;

import br.com.frsiqueira.challengebackend.controller.ItemController;
import br.com.frsiqueira.challengebackend.service.ItemService;
import br.com.frsiqueira.challengebackend.service.ItemServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ItemControllerConfig {

    @Bean
    public ItemController itemController() {
        return new ItemController();
    }

    @Bean
    public ItemService itemService() {
        return new ItemServiceImpl();
    }
}
