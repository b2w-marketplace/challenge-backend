package br.com.b2w.api.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@RequestMapping(value="/item/{dataInit}/{dataFim}", method = RequestMethod.GET)
	public void teste(@PathVariable("dataInit") String dataInit,
			@PathVariable("dataFim") String dataFim) throws ParseException {
		
		List<Item> lista = itemService.getItens();
		
		lista.forEach(System.out::println);
	}
}
