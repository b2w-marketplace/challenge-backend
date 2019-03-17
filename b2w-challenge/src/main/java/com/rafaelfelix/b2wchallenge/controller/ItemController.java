package com.rafaelfelix.b2wchallenge.controller;

import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.rafaelfelix.b2wchallenge.dto.ProductDTO;
import com.rafaelfelix.b2wchallenge.util.ParseDate;

/**
 * Classe de controle dos serviços
 * 
 * @author rafaelfelixmoraes
 *
 */

@RestController("/item")
public class ItemController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ItemController.class);
	
	// Endereço da API a ser consumida pelos serviços
	private static final String publicApiUrl = "http://www.mocky.io/v2/5817803a1000007d01cc7fc9";
		
	/**
	 * Método respopnsável por realizar a chamada de uma API pública e popular uma lista de Produtos
	 * 
	 * @return List<{@link ProductDTO}> A lista de produtos populada
	 * @throws UnknownHostException Caso o sistema não encontre a URL da Api pública
	 */
	private List<ProductDTO> callServiceJson(String apiURL) throws UnknownHostException {
		List<ProductDTO> produtos = new ArrayList<ProductDTO>();
		try {
			RestTemplate template = new RestTemplate();
			ResponseEntity<ProductDTO[]> response = template.getForEntity(apiURL, ProductDTO[].class);
			produtos = Arrays.asList(response.getBody());
		} catch(HttpServerErrorException ex) {
			LOGGER.error("Causa: ".concat(ex.getCause().toString()).concat(". Detalhe: ").concat(ex.getMessage()));
			throw new HttpServerErrorException(HttpStatus.BAD_REQUEST, "Ocorreu um erro ao tentar chamar a API pública");
		}
		return produtos;
	}
	
	
	/**
	 * Método respopnsável por listar os produtos filtrando por data inicial e final
	 * 
	 * @return ResponseEntity<List<{@link ProductDTO}>> A entidade contendo a lista dos produtos conforme filtro definido
	 * @throws UnknownHostException Caso o sistema não encontre a URL da Api pública
	 */

	@GetMapping(value = "/{begindate}/{finaldate}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> findByDateInterval(
			@RequestParam(value = "begindate") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate pBeginDate,
			@RequestParam(value = "finaldate") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate pFinalDatee) throws UnknownHostException {
		
		LocalDateTime beginDT = ParseDate.toLocalDateTime(pBeginDate);
		LocalDateTime finalDT = ParseDate.toLocalDateTime(pFinalDatee);
		
		List<ProductDTO> productsList = callServiceJson(publicApiUrl);
		if (productsList != null) {
			if(productsList.size() > 0) {
				productsList = productsList.stream().
						filter(x -> (((ProductDTO) x).getDate().isAfter(beginDT) || ((ProductDTO) x).getDate().isEqual(beginDT))
								&& (((ProductDTO) x).getDate().isBefore(finalDT) || ((ProductDTO) x).getDate().isEqual(finalDT)))
								.collect(Collectors.toList());
			}
		}
		
		return ResponseEntity.ok(productsList);
	}
}
