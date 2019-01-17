package com.liuxu.online.config;//package com.gome.meidian.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;

import javax.sql.DataSource;


/**
 * @author sunxueyan-ds
 * @Title: DataSourceConfigTwo
 * @ProjectName meidian-service-order
 * @Description: TODO
 * @date 2019/1/10 18:00
 */
@Configuration
@MapperScan(basePackages = "com.liuxu.online.mapper.bigData*", sqlSessionTemplateRef = "bigDataSqlSessionTemplate")
public class DataSourceConfigTwo {

    @Bean(name = "bigDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.bigdata")
//    @Primary
    public DataSource bigDataSource(){ return DataSourceBuilder.create().build();
    }

    @Bean(name = "bigDataSqlSessionFactory")
    @ConfigurationProperties(prefix ="mybatis-plus2")
//    @ConfigurationPropertiesBinding()
//    @Primary
    public SqlSessionFactory bigDataSqlSessionFactory(@Qualifier("bigDataSource") DataSource dataSource) throws Exception{
        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(bigDataSource());
//        sqlSessionFactoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mapper/bigData/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "bigDataTransactionManager")
//    @Primary
    public DataSourceTransactionManager bigDataTransactionManager(@Qualifier("bigDataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "bigDataSqlSessionTemplate")
//    @Primary
    public SqlSessionTemplate bigDataSqlSessionTemplate(@Qualifier("bigDataSqlSessionFactory")SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
