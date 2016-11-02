package br.com.b2w.api.service;

import static java.util.stream.Collectors.toList;

import java.time.LocalDate;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.b2w.api.model.Item;
import br.com.b2w.api.util.Util;

@Service(value = "itemService")
@Component
public class ItemService {

	private static final String URL_BASE = "http://www.mocky.io/v2/5817803a1000007d01cc7fc9";

	public List<Item> getItens(String dataInit, String dataFim) {
		return getItensAndFilter(Util.parse(dataInit), Util.parse(dataFim));
	}

	private List<Item> getItensAndFilter(LocalDate dateInit, LocalDate dateFim) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Item>> itemResponse = restTemplate.exchange(URL_BASE, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Item>>() {
				});
		
		return itemResponse.getBody().stream()
				.filter(item -> (item.getDate().isAfter(dateInit) || item.getDate().equals(dateInit))
						&& (item.getDate().isBefore(dateFim) || item.getDate().equals(dateFim)))
				.collect(toList());
	}
}
