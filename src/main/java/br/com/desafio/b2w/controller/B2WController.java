package br.com.desafio.b2w.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.b2w.dto.Item;
import br.com.desafio.b2w.service.B2WService;

@RestController
@ComponentScan
@RequestMapping("/challenge-backend")
public class B2WController {

	@Autowired
	private B2WService b2wService;

	@RequestMapping(value = "/item", method = RequestMethod.GET)
	public List<Item> getItens(@RequestParam(value="begindate", required=false) @DateTimeFormat(pattern="dd-MM-yyyy") Calendar beginDate, 
							   @RequestParam(value="finaldate", required=false) @DateTimeFormat(pattern="dd-MM-yyyy") Calendar finalDate) throws ParseException {
		
		List<Item> itens = b2wService.getItens();
		if(itens == null || itens.isEmpty()) 
			return null;
		
		if(beginDate == null || finalDate == null) 
			return itens;
		
		beginCalendar(beginDate);
		finalCalendar(finalDate);
		
		List<Item> filter = itens.stream().filter(l -> (l.getDate() != null && l.getDate().compareTo(beginDate) >= 0) && 
				(l.getDate() != null && l.getDate().compareTo(finalDate) <= 0)).collect(Collectors.toList());
	
		return filter;
	}
	
	@RequestMapping("/")
	@ResponseBody
	public String home() {
		return "home";
	}
	
	private void beginCalendar(Calendar calendar) throws ParseException{
		initCalendar(calendar, true);
	}
	
	private void finalCalendar(Calendar calendar) throws ParseException{
		initCalendar(calendar, false);
	}
	
	private void initCalendar(Calendar calendar, boolean isInitTime) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		calendar.setTime(format.parse(format.format(calendar.getTime())));
		
		calendar.set(Calendar.HOUR, isInitTime ? 00 : 23);
		calendar.set(Calendar.MINUTE, isInitTime ? 00 : 59);
		calendar.set(Calendar.SECOND, isInitTime ? 00 : 59);
		calendar.set(Calendar.MILLISECOND, isInitTime ? 0000 : 9999);
	}
}