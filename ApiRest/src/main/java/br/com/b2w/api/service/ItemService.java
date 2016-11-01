package br.com.b2w.api.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.b2w.api.model.Item;

@Service(value="itemService")
@Component
public class ItemService {

	public List<Item> getItens() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Item>> itemResponse =
				restTemplate.exchange("http://www.mocky.io/v2/5817803a1000007d01cc7fc9", 
						HttpMethod.GET, null, new ParameterizedTypeReference<List<Item>>() {
		});
		return itemResponse.getBody();
	}
}
