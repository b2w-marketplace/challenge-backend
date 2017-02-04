package br.com.b2w.marketplace.service;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.google.gson.Gson;

import br.com.b2w.marketplace.response.Item;
import br.com.b2w.marketplace.response.ItemList;


/**
 * 
 * @author Felipe
 *
 *         Classe responsável por invocar a API externa através de HTTP request
 *
 */
@Service
public class MockyAPIService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MockyAPIService.class);
	
	public ItemList recuperarItens(final String endpointApit) {

		ItemList itemList = new ItemList();
		
		try {

			final HttpPost requestPost = new HttpPost(endpointApit);

			final HttpClient httpClient = HttpClients.custom().build();

			final CookieStore cookieStore = new BasicCookieStore();
			final HttpContext httpContext = new BasicHttpContext();

			httpContext.setAttribute("http.cookie-store", cookieStore);

			HttpResponse responseHttp = httpClient.execute(requestPost, httpContext);

			HttpEntity httpEntity = responseHttp.getEntity();
			
			if (!ObjectUtils.isEmpty(httpEntity)) {
				
				String responseAsString = EntityUtils.toString(httpEntity);
				
				JSONArray jsonArray = new JSONArray(responseAsString);
				
				for (int index = 0; index < jsonArray.length(); index++) {
					
					JSONObject object = jsonArray.getJSONObject(index);
					
					Item item = new Gson().fromJson(object.toString(), Item.class);
					LOGGER.debug("Adicionando " + item);
					
					itemList.addItem(item);
					
				}
				
			}

			((CloseableHttpClient) httpClient).close();

		} catch (Exception ex) {
			LOGGER.error("ERRO ao se comunicar com API externa: " 
					+ ex.getMessage(), ex);
		}

		LOGGER.debug("Total de itens encontrados :: " + itemList.list().size());
		
		return itemList;
	}

}
