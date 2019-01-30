package com.liuxu.online.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;



@Configuration
@MapperScan(basePackages = "com.liuxu.online.mapper.order*", sqlSessionTemplateRef = "orderSqlSessionTemplate")
public class MybatisPlusConfig {
	/**
	 * mybatis-plus mybatis plus 优化【生产环境可以关闭】
	 */
/*	@Bean
	public PerformanceInterceptor performanceInterceptor() {
		PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
		//<!-- SQL 执行性能分析，开发环境使用，线上不推荐。 maxTime 指的是 sql 最大执行时长 -->
        performanceInterceptor.setMaxTime(1000);
        //<!--SQL是否格式化 默认false-->
        performanceInterceptor.setFormat(true);
		return new PerformanceInterceptor();
	}*/

	@Bean(name = "orderDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.order")
	@Primary
	public DataSource orderDataSource(){ return DataSourceBuilder.create().build();
	}

	@Bean(name = "orderSqlSessionFactory")
	@ConfigurationProperties(prefix ="mybatis-plus")
	@Primary
	public SqlSessionFactory orderSqlSessionFactory(@Qualifier("orderDataSource") DataSource dataSource) throws Exception{
		MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(orderDataSource());
//		sqlSessionFactoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath*:mapper/order/*.xml"));
		return sqlSessionFactoryBean.getObject();
	}

	@Bean(name = "orderTransactionManager")
	@Primary
	public DataSourceTransactionManager orderTransactionManager(@Qualifier("orderDataSource") DataSource dataSource){
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = "orderSqlSessionTemplate")
	@Primary
	public SqlSessionTemplate orderSqlSessionTemplate(@Qualifier("orderSqlSessionFactory")SqlSessionFactory sqlSessionFactory){
		return new SqlSessionTemplate(sqlSessionFactory);
	}

	/**
	 * mybatis-plus分页插件<br>
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
		paginationInterceptor.setLocalPage(true);// 开启 PageHelper 的支持
		return paginationInterceptor;
	}
}
