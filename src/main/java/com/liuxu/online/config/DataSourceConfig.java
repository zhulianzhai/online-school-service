package com.liuxu.online.config;

import org.springframework.context.annotation.Configuration;


@Configuration
public class DataSourceConfig {
	
/*	@Bean(name = "dataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return new DruidDataSource();
	}

	@Bean(name = "transactionManager")
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}*/
}
