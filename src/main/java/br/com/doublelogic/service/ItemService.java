package br.com.doublelogic.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.doublelogic.entity.Item;
import br.com.doublelogic.service.client.ItemDataClient;

@Service
@Path("/item")
public class ItemService {
	
	private final Logger logger = LoggerFactory.getLogger(getClass()); 
	
	@Autowired
	private ItemDataClient itemDataClient;
	
	private final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String item(@QueryParam("begindate") String beginDate, @QueryParam("finaldate") String finalDate) throws ParseException, JsonProcessingException {
		Date dtStart = sdf.parse(beginDate);
		Date dtFinish = sdf.parse(finalDate);
		
		//this should be cached
		List<Item> data = itemDataClient.getItems();

		List<Item> result = data.stream()
				.filter(item -> {
					try {
						//hours won´t be considered
						Date itemDate = sdf.parse(sdf.format(item.getDate()));
						return dateBetween(dtStart, dtFinish, itemDate);
					} catch (ParseException e) {
						logger.error(e.getMessage(), e);
					}
					return false;
				})
				.collect(Collectors.toList());
		
		return convertJSON(result);
	}
	
	private String convertJSON(List<Item> data) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(data);
	}
	
	private boolean dateBetween(Date start, Date finish, Date date) {
		if(date.getTime() >= start.getTime() && date.getTime() <= finish.getTime()) 
			return true;
		else
			return false;
	}
	
}