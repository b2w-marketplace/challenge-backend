package br.com.frsiqueira.challengebackend.config;

import br.com.frsiqueira.challengebackend.service.ItemService;
import br.com.frsiqueira.challengebackend.service.impl.ItemServiceImpl;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.mock;

@Configuration
public class ItemServiceConfig {

    @Bean
    public ItemService itemService() {
        return new ItemServiceImpl();
    }

    @Bean
    public RestTemplate restTemplate() {
        return mock(RestTemplate.class);
    }

}
