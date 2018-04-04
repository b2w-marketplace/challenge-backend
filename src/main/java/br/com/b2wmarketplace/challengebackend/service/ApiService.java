package br.com.b2wmarketplace.challengebackend.service;

import br.com.b2wmarketplace.challengebackend.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ApiService {

    @Value("${api.url}")
    private String apiUrl;

    public List<Product> filter(LocalDate beginDate, LocalDate finalDate) {

        ResponseEntity<Product[]> responseEntity = new RestTemplate().getForEntity(apiUrl, Product[].class);

        if (responseEntity.getStatusCode() == HttpStatus.OK) {

            final LocalDateTime finalDateTime = finalDate.atStartOfDay().plusDays(1).minusSeconds(1);

            return Stream.of(responseEntity.getBody())
                    .filter(product -> product.getDate().isAfter(beginDate.atStartOfDay()) && product.getDate().isBefore(finalDateTime))
                    .collect(Collectors.toList());

        }

        return null;

    }

}
