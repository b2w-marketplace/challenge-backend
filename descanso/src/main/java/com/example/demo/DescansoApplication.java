package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignFormatterRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@EnableFeignClients
@SpringBootApplication
public class DescansoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DescansoApplication.class, args);
	}
	
	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
	    ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	    MappingJackson2HttpMessageConverter converter = 
	        new MappingJackson2HttpMessageConverter(mapper);
	    return converter;
	}
	
	@Bean
	public FeignFormatterRegistrar localDateFeignFormatterRegistrar() {
	    return new FeignFormatterRegistrar() {
	        @Override
	        public void registerFormatters(FormatterRegistry formatterRegistry) {
	            DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
	            registrar.setUseIsoFormat(true);
	            registrar.registerFormatters(formatterRegistry);
	        }
	    };
	}

}
