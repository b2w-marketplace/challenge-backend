package br.com.b2w.challengebackend.dto.conversor;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by anderson on 03/11/16.
 */

public class LocalDateTimeDeserializer extends StdDeserializer<LocalDateTime> {

    private static final String FORMATO_DATA;

    static {
        FORMATO_DATA = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    }

    public LocalDateTimeDeserializer() {
        super(LocalDateTime.class);
    }

    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return LocalDateTime.parse(jsonParser.getValueAsString(), DateTimeFormatter.ofPattern(FORMATO_DATA));
    }
}
