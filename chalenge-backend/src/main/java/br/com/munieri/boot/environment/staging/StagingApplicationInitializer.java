package br.com.munieri.boot.environment.staging;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile("staging")
@PropertySource("classpath:application-dev.properties")
public class StagingApplicationInitializer {
}
