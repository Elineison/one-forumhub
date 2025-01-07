package com.alura.forumhub.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class FlywayConfig {

    @Autowired
    public void configureFlayway(DataSource dataSource, Environment env) {
        Flyway flyway = Flyway.configure()
                .baselineOnMigrate(true)
                .baselineVersion("0")
                .dataSource(dataSource)
                .cleanDisabled(false)
                .load();

        try {
            // Limpa o banco de dados antes de migrar
            flyway.clean();
            flyway.migrate();
        } catch (Exception e) {
            // Log the error
            e.printStackTrace();
        }
    }
}