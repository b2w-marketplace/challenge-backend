package com.kelvincarvalho.challengeb2w;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ChallengeB2wApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeB2wApplication.class, args);
	}

}
