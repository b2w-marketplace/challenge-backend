package br.com.b2w.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.b2w.api.model.Item;
import br.com.b2w.api.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	ItemService itemService;

	@RequestMapping(value = "/item", method = RequestMethod.GET)
	public ResponseEntity<List<Item>> findItemByDate(@RequestParam("begindate") String dataInit,
			@RequestParam("finaldate") String dataFim) {
		
		List<Item> itens = itemService.getItens(dataInit, dataFim);
		
		if (itens.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(itemService.getItens(dataInit, dataFim), HttpStatus.OK);
	}
}
