package br.com.doublelogic;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import br.com.doublelogic.service.ItemService;

@Configuration
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(ItemService.class);
	}
	
}
