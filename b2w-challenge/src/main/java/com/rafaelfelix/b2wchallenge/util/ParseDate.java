package com.rafaelfelix.b2wchallenge.util;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Classe utilitária para conversão customizadas de Datas
 * 
 * @author rafaelfelixmoraes
 *
 */
public class ParseDate implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * Função que converte um objeto {@link LocalDate} para {@link LocalDateTime}
	 * 
	 * @param dateToParse A data a ser convertida
	 * @return A data convertida para um objeto {@link LocalDateTime.java}
	 */
	public static LocalDateTime toLocalDateTime(LocalDate dateToParse) {
		return LocalDateTime.of(dateToParse, LocalDateTime.MIN.toLocalTime());
	}

}
