package br.com.b2w.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Projeto do desafio de backend - B2W Marktplace
 * 
 * @author Rafael Felix de Moraes
 *
 */

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.b2w.controller"})
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
