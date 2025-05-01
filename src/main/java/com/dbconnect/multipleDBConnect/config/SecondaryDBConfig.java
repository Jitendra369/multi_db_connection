package com.dbconnect.multipleDBConnect.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

// audit repo configuration

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.dbconnect.multipleDBConnect.repo.audit",
        entityManagerFactoryRef = "secondaryEntityManager",
        transactionManagerRef = "secondaryTxManager"
)
public class SecondaryDBConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.secondary")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    private Map<String, Object> secondaryJPAProperties(){
        Map<String, Object> props = new HashMap<>();
        props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        props.put("hibernate.hbm2ddl.auto", "update");
        props.put("hibernate.show_sql", true);
        return  props;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean secondaryEntityManager(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(secondaryDataSource())
                .packages("com.dbconnect.multipleDBConnect.entities.auditentity")
                .persistenceUnit("secondary")
                .properties(secondaryJPAProperties())
                .build();
    }

    @Bean
    public PlatformTransactionManager secondaryTxManager(
            @Qualifier("secondaryEntityManager") EntityManagerFactory factory) {
        return new JpaTransactionManager(factory);
    }
}
