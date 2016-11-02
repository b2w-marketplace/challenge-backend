package br.com.guilherme.rest.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.guilherme.rest.model.Item;
import br.com.guilherme.rest.service.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	private ItemService service;

	/**
	 * @return the service
	 */
	public ItemService getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(ItemService service) {
		this.service = service;
	}

	@RequestMapping(value = "/item", method = RequestMethod.GET)
	public List<Item> listaItens(@RequestParam(value = "begindate") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate beginDate,
			@RequestParam(value = "finaldate") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate finalDate) {
		return service.filter(beginDate, finalDate);
	}

}
