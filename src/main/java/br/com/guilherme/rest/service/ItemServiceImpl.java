package br.com.guilherme.rest.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import br.com.guilherme.rest.model.Item;

@Service
public class ItemServiceImpl implements ItemService {
	
	private static final String URL = "http://www.mocky.io/v2/5817803a1000007d01cc7fc9";
	
	private List<Item> executeService() {
		List<Item> itens = new ArrayList<>();
		try {
			RestTemplate template = new RestTemplate();
			ResponseEntity<Item[]> resp = template.getForEntity(URL, Item[].class);
			itens = Arrays.asList(resp.getBody());
		} catch(HttpServerErrorException ex) {
			itens = new ArrayList<>();
		}
		return itens;
	}

	public List<Item> filter(LocalDate beginDate, LocalDate finalDate) {
		List<Item> itens = executeService();
		if(itens.size() > 0) {
			itens = itens.stream().
					filter(x -> (x.getDate().isAfter(beginDate) || x.getDate().isEqual(beginDate))
							&& (x.getDate().isBefore(finalDate) || x.getDate().isEqual(finalDate))).
					collect(Collectors.toList());
		}
		return itens;
	}

}
