package br.com.b2w.marketplace.component;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.b2w.marketplace.BaseTest;
import br.com.b2w.marketplace.response.Item;
import br.com.b2w.marketplace.response.ItemList;

public class ItemFilterComponentTest extends BaseTest {

	@Autowired
	private ItemFilterComponent itemFilterComponent; 
	
	private static final String BEGIN_DATE_PARAM = "05-10-2016";
	
	private static final String FINAL_DATE_PARAM = "10-10-2016";
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFiltrarRegistros() {
		
		ItemList itemList = new ItemList();

		Item item1 = new Item("Caixa de Som", "4", "2016-10-04T14:30:37.040Z", null);
		itemList.addItem(item1);
		
		Item item2 = new Item("Impressora", "5", "2016-10-05T14:30:37.040Z", null);
		itemList.addItem(item2);
		
		Item item3 = new Item("Forno", "13", "2016-10-13T14:30:37.040Z", null);
		itemList.addItem(item3);
		
		itemList = this.itemFilterComponent
				.filtrarRegistros(BEGIN_DATE_PARAM, FINAL_DATE_PARAM, itemList.list());
		
		Assert.assertTrue(itemList.list().size() == 1);
		
	}

}
