package br.com.b2w.api.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.b2w.api.model.Item;
import br.com.b2w.api.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	ItemService itemService;

	@RequestMapping(value = "/item/{dataInit}/{dataFim}", method = RequestMethod.GET)
	public ResponseEntity<List<Item>> findItemByDate(@PathVariable("dataInit") String dataInit,
			@PathVariable("dataFim") String dataFim) throws ParseException {
		
		List<Item> itens = itemService.getItens(dataInit, dataFim);
		
		if (itens.isEmpty()) {
			return new ResponseEntity<List<Item>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Item>>(itemService.getItens(dataInit, dataFim), HttpStatus.OK);
	}
}
