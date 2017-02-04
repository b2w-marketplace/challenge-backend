package br.com.b2w.marketplace.response;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.b2w.marketplace.BaseTest;

public class ItemListTest extends BaseTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAddItem() {

		ItemList itemList = new ItemList();
		
		Assert.assertNotNull(itemList.list());
		Assert.assertTrue(itemList.list().size() <= 0);
	
		Item item = new Item("name", "code", "date", null);
		
		Assert.assertTrue(itemList.addItem(item));
		Assert.assertTrue(itemList.list().size() > 0);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddItemIllegalArgumentException() {

		ItemList itemList = new ItemList();
		
		itemList.addItem(null);

	}

	@Test
	public void testEmptyList() {

		ItemList itemList = new ItemList();
		
		Assert.assertNotNull(itemList.list());
		Assert.assertTrue(itemList.list().size() <= 0);
		
	}

}
