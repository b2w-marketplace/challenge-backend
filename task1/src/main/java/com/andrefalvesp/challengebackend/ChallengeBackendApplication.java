package com.andrefalvesp.challengebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients

public class ChallengeBackendApplication {

  public static void main(String[] args) {
    SpringApplication.run(ChallengeBackendApplication.class, args);
  }
}