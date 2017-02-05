package br.com.doublelogic.service.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.doublelogic.entity.Item;

/**
 * 
 * Service client to load items data
 * 
 * @author diego
 *
 */
@Service
public class ItemDataClient {

	private final String uri = "http://www.mocky.io/v2/5817803a1000007d01cc7fc9";
	
	public List<Item> getItems() {
		RestTemplate restTemplate = new RestTemplate();
		Item[] data = restTemplate.getForObject(uri, Item[].class);
		return Arrays.asList(data);
	}
}
