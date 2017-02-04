package br.com.b2w.marketplace.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.b2w.marketplace.BaseTest;
import br.com.b2w.marketplace.controller.ItemRestController;
import br.com.b2w.marketplace.response.ItemList;

public class MockyAPIServiceTest extends BaseTest {

	@Autowired
	private MockyAPIService mockyApiService;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testRecuperarItens() {
		
		ItemList itemList = this.mockyApiService
				.recuperarItens(ItemRestController.ENDPOINT_API);
		
		Assert.assertNotNull(itemList);
		Assert.assertTrue(itemList.list().size() > 0);
		
	}

}
