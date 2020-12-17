package com.leonardossev.challengebackend.configuration;

import lombok.SneakyThrows;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.SimpleDateFormat;
import java.time.*;

@EnableWebMvc
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToZonedDateTime());
    }

    private static class StringToZonedDateTime implements Converter<String, ZonedDateTime> {

        @SneakyThrows
        @Override
        public ZonedDateTime convert(String dateAsString) {
            var date = new SimpleDateFormat("dd-MM-yyyy").parse(dateAsString);

            return ZonedDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        }
    }
}
