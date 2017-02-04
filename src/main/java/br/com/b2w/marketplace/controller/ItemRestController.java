package br.com.b2w.marketplace.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.b2w.marketplace.component.ItemFilterComponent;
import br.com.b2w.marketplace.response.ItemList;
import br.com.b2w.marketplace.service.MockyAPIService;

@RestController
public class ItemRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ItemRestController.class);
	
	public static final String ENDPOINT_API = "http://www.mocky.io/v2/5817803a1000007d01cc7fc9";
	
	private static final String BEGIN_DATE_PARAM = "begindate";
	private static final String FINAL_DATE_PARAM = "finaldate";

	private MockyAPIService mockyApiService;
	
	private ItemFilterComponent itemFilterComponent;

	@Autowired
	public ItemRestController(MockyAPIService httpClientService, ItemFilterComponent itemFilterComponent) {
		this.mockyApiService = httpClientService;
		this.itemFilterComponent = itemFilterComponent;
	}
	
	@RequestMapping(value = { "/item" }, method = { RequestMethod.GET, RequestMethod.POST }, 
			headers="Accept=*/*", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<?> recuperarItens(final HttpServletRequest request) {
		LOGGER.info("Preparando para recuperar itens...");
		
		final String beginDate = request.getParameter(BEGIN_DATE_PARAM);
		
		final String finalDate = request.getParameter(FINAL_DATE_PARAM);
		
		if (StringUtils.isEmpty(beginDate) || StringUtils.isEmpty(finalDate)) {
			LOGGER.info("Parametros [ " + BEGIN_DATE_PARAM + " ], [ " +  FINAL_DATE_PARAM + " ] nao preenchidos");
			return new ResponseEntity<String>("[]", HttpStatus.BAD_REQUEST);
		}
		
		try {

			// Invoca a API externa para recuperação de itens
			ItemList itemList = this.mockyApiService.recuperarItens(ENDPOINT_API);
			
			itemList = this.itemFilterComponent
					.filtrarRegistros(beginDate, finalDate, itemList.list());
			
			return new ResponseEntity<String>(new Gson().toJson(itemList.list()), 
					HttpStatus.OK);
			
		} catch (Exception ex) {
			LOGGER.error("ERRO ao recuperar itens: " 
					+ ex.getMessage(), ex);
			return new ResponseEntity<String>("[]", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
}
