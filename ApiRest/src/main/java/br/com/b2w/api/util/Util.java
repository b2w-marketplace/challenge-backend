package br.com.b2w.api.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Util {
	
	public static LocalDate parse(String data) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		return LocalDate.parse(data, formatter);
	}

}
