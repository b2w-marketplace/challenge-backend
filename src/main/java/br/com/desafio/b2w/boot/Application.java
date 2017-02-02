package br.com.desafio.b2w.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.com.desafio.b2w")
public class Application {
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}