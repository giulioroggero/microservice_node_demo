package com.sirti.microservice.hbase.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;



/**
 * Created by hadoop on 06/12/14.
 */
@Configuration
@PropertySource("classpath:querybuilder.properties")
public class QueryBuilderConfig {
  final static Logger logger = LoggerFactory.getLogger(QueryBuilderConfig.class);

  private static final String PROPERTY_NAME_DATABASE_DRIVER = "querybuilder.hbase.driver";
  private static final String PROPERTY_NAME_DATABASE_USERNAME = "querybuilder.hbase.user";
  private static final String PROPERTY_NAME_DATABASE_PASSWORD = "querybuilder.hbase.password";
  private static final String PROPERTY_NAME_DATABASE_URL = "querybuilder.hbase.url";

  @Resource
  private Environment env;

  @Bean(destroyMethod = "close")
  public DataSource dataSource() throws PropertyVetoException {
    // DriverManagerDataSource dataSource = new DriverManagerDataSource();
    // dataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
    // dataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
    // dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
    // dataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));

    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    dataSource.setDriverClass(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
    dataSource.setUser(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
    dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
    dataSource.setJdbcUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));

    // the settings below are optional -- c3p0 can work with defaults
    // dataSource.setMinPoolSize(5);
    // dataSource.setAcquireIncrement(5);
    // dataSource.setMaxPoolSize(20);
    return dataSource;
  }

  @Bean
  public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
    return new PropertySourcesPlaceholderConfigurer();
  }
}
