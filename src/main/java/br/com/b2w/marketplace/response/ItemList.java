package br.com.b2w.marketplace.response;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.ObjectUtils;

public class ItemList {

	private List<Item> itemList;

	public ItemList() {
		this.itemList = new ArrayList<Item>();
	}
	
	public boolean addItem(Item item) throws IllegalArgumentException {
		
		if (ObjectUtils.isEmpty(item)) {
			throw new IllegalArgumentException("Item nao pode ser nulo");
		}
		
		return itemList.add(item);
		
	}
	
	public List<Item> list() {
		return this.itemList;
	}
	
}
