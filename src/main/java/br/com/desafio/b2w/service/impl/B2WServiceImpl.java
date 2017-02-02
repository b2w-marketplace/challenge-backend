package br.com.desafio.b2w.service.impl;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.desafio.b2w.dto.Item;
import br.com.desafio.b2w.service.B2WService;

@Service
public class B2WServiceImpl implements B2WService {
	
	private final String GET_URI = "http://www.mocky.io/v2/5817803a1000007d01cc7fc9";
	
	@Override
	public List<Item> getItens(){
		ResponseEntity<List<Item>> rateResponse = new RestTemplate().exchange(GET_URI, HttpMethod.GET, null, new ParameterizedTypeReference<List<Item>>() {});
		List<Item> itens = rateResponse.getBody();
		
		return itens;
	}
}
