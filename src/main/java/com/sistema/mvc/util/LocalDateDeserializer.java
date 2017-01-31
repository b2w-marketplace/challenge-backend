/**
 * Projeto Challenge Backend
 *
 * @author <a href="mailto:leandrorcom@gmail.com">Leandro Rodrigues Combinato</a>
 */
package com.sistema.mvc.util;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/*
 * Classe responsável por Deserializar a data inicio e data final  
 */

public class LocalDateDeserializer extends JsonDeserializer<LocalDate> {

	@Override
	public LocalDate deserialize(JsonParser arg0, DeserializationContext arg1) throws IOException, JsonProcessingException {
		return Instant.parse(arg0.getText()).atZone(ZoneId.systemDefault()).toLocalDate();
	}

}
