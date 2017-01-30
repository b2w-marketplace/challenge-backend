package br.com.munieri.boot.environment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.ejb.HibernatePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Properties;

@Configuration
@ComponentScan("br.com.munieri")
@EnableJpaRepositories({"br.com.munieri.infrastructure.repository"})
@EnableWebMvc
public class ApplicationInitializer {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String PACKAGES = "br.com.munieri.infrastructure.repository";

    @Value("${jdbc.driver}")
    private String jdbcDriver;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.user}")
    private String jdbcUser;

    @Value("${jdbc.pass}")
    private String jdbcPass;

    @Value("${jdbc.dialect}")
    private String jdbcDialect;

    public ApplicationInitializer() throws Exception {
        LOGGER.info("Inicializando aplicacao");
    }

    @Autowired
    private Environment env;

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
    @Bean
    public DriverManagerDataSource dataSource() {
        LOGGER.info("Configurando [dataSource]...");
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(jdbcDriver);
        ds.setUrl(jdbcUrl);
        ds.setUsername(jdbcUser);
        ds.setPassword(jdbcPass);
        LOGGER.info("Datasource configurado: " + ds.toString());
        return ds;
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LOGGER.info("Configurando [entityManagerFactory]...");
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPackagesToScan(PACKAGES);
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);
        entityManagerFactoryBean.setJpaProperties(hibernateProperties());
        LOGGER.info(entityManagerFactoryBean);
        return entityManagerFactoryBean;
    }
    private Properties hibernateProperties() {
        return new Properties() {
            {
                setProperty("hibernate.hbm2ddl.auto", "create");
                setProperty("hibernate.dialect", jdbcDialect);
                setProperty("hibernate.format_sql", "true");
                setProperty("hibernate.show_sql", "true");
            }
        };
    }
    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    //To resolve ${} in @Value
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}

