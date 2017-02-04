package br.com.b2w.marketplace.component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import br.com.b2w.marketplace.response.Item;
import br.com.b2w.marketplace.response.ItemList;

@Component
public class ItemFilterComponent {

	private static final Logger LOGGER = LoggerFactory.getLogger(ItemFilterComponent.class);
	
	private String padronizarDatasParametros(String dataOriginal) {
		String[] parcial = dataOriginal.split("-");
		return (parcial[2].concat("-")
				.concat(parcial[1]).concat("-")
				.concat(parcial[0]));
	}
	
	public ItemList filtrarRegistros(String beginDate, String finalDate, List<Item> itens) {
		
		beginDate = this.padronizarDatasParametros(beginDate);
		finalDate = this.padronizarDatasParametros(finalDate);
		
		ItemList itemList = new ItemList();
		
		try {
		
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			Date beginDateDateType = sdf.parse(beginDate);
			Date finalDateDateType = sdf.parse(finalDate);
			
			for (Item item : itens) {
				
				Date dateDateType = sdf.parse(item.getDate()
						.substring(0, item.getDate().indexOf("T")));
				
				Calendar dateCalendarType = Calendar.getInstance();
				dateCalendarType.setTime(dateDateType);
				
				if (dateDateType.compareTo(beginDateDateType) >= 0
						&& dateDateType.compareTo(finalDateDateType) <= 0) {
					
					itemList.addItem(item);

				}
				
			}
			
			
		} catch (Exception ex) {
			LOGGER.error("ERRO formatacao datas: " 
					+ ex.getMessage(), ex);
		}
		
		return itemList;
		
	}

}
