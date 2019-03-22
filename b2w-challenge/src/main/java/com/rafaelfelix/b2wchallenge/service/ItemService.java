package com.rafaelfelix.b2wchallenge.service;

import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.rafaelfelix.b2wchallenge.dto.ProductDTO;
import com.rafaelfelix.b2wchallenge.util.ParseDate;

@Service
public class ItemService {

	@Autowired
	private Environment environment;

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * Método respopnsável por realizar a chamada de uma API pública e popular uma lista de Produtos
	 * 
	 * @return List<{@link ProductDTO}> A lista de produtos populada
	 * @throws UnknownHostException Caso o sistema não encontre a URL da Api pública
	 */
	private List<ProductDTO> getApiJSON(String apiURL) throws UnknownHostException {
		List<ProductDTO> produtos = new ArrayList<ProductDTO>();
		try {
			ResponseEntity<ProductDTO[]> response = restTemplate.getForEntity(apiURL, ProductDTO[].class);
			produtos = Arrays.asList(response.getBody());
		} catch (HttpServerErrorException ex) {
			throw new HttpServerErrorException(HttpStatus.BAD_REQUEST,
					"Ocorreu um erro ao tentar chamar a API pública");
		}
		return produtos;
	}

	/**
	 * Método respopnsável por listar os produtos filtrando por data inicial e final
	 * 
	 * @return ResponseEntity<List<{@link ProductDTO}>> A entidade contendo a lista dos produtos conforme filtro definido
	 * @throws UnknownHostException Caso o sistema não encontre a URL da Api pública
	 */
	public List<ProductDTO> searchFilter(LocalDate beginDate, LocalDate finalDate) throws UnknownHostException {
		String publicApiUrl = environment.getProperty("public.api.url");
		LocalDateTime beginDT = ParseDate.toLocalDateTime(beginDate);
		LocalDateTime finalDT = ParseDate.toLocalDateTime(finalDate);

		List<ProductDTO> productsList = getApiJSON(publicApiUrl);
		if (productsList != null) {
			if (productsList.size() > 0) {
				productsList = productsList.stream()
										   .filter(x -> (((ProductDTO) x).getDate().isAfter(beginDT)
												   		|| ((ProductDTO) x).getDate().isEqual(beginDT))
												   		&& (((ProductDTO) x).getDate().isBefore(finalDT)
												   		|| ((ProductDTO) x).getDate().isEqual(finalDT)))
										   .collect(Collectors.toList());
			}
		}

		return productsList;
	}
}
