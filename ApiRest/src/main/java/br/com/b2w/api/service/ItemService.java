package br.com.b2w.api.service;

import static java.util.stream.Collectors.toList;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.b2w.api.model.Item;

@Service(value = "itemService")
@Component
public class ItemService {

	public List<Item> getItens(String dataInit, String dataFim) throws ParseException {

		Date dateInit = parse(dataInit);
		Date dateFim = parse(dataFim);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Item>> itemResponse = restTemplate.exchange(
				"http://www.mocky.io/v2/5817803a1000007d01cc7fc9", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Item>>() {});

		return itemResponse.getBody().stream()
				.filter(item -> item.getDate().after(dateInit) && item.getDate().before(dateFim)).collect(toList());
	}

	private Date parse(String data) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		return formatter.parse(data);
	}
}
