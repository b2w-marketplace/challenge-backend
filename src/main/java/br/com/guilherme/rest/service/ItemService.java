package br.com.guilherme.rest.service;

import java.time.LocalDate;
import java.util.List;

import br.com.guilherme.rest.model.Item;

public interface ItemService {
	
	List<Item> filter(LocalDate beginDate, LocalDate finalDate);

}
