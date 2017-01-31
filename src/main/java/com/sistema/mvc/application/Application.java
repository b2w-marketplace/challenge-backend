/**
 * Projeto Challenge Backend
 *
 * @author <a href="mailto:leandrorcom@gmail.com">Leandro Rodrigues Combinato</a>
 */
package com.sistema.mvc.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sistema.mvc.controller"})
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
