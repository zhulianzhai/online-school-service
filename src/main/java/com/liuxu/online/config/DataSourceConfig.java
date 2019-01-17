package com.liuxu.online.config;

import org.springframework.context.annotation.Configuration;

/** 
 * @ClassName: DataSourceConfig 
 * @Description: 数据库全局配置 
 * @author likaile
 * @date 2018年4月28日 上午10:52:22  
 */ 
 
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
