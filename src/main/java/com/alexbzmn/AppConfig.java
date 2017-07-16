package com.alexbzmn;

import com.alexbzmn.controller.MvcConfig;
import com.alexbzmn.dao.PostDao;
import com.alexbzmn.security.WebSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

/**
 * Created by User on 7/16/2017.
 */
@EnableWebMvc
@Configuration
@ComponentScan({"com.alexbzmn.*"})
@Import({WebSecurityConfig.class, MvcConfig.class})
public class AppConfig {

    @Bean(name = "jdbcTemplate")
    public JdbcTemplate jdbcTemplate(@Autowired DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public PostDao postDao(@Autowired JdbcTemplate jdbcTemplate) {
        return new PostDao(jdbcTemplate);
    }

    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.sqlite.JDBC");
        driverManagerDataSource.setUrl("jdbc:sqlite:knockblog.db");
        return driverManagerDataSource;
    }
}
