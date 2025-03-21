package com.example.nrs.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("classpath:/application.properties")
public class DatabaseConfig {
	
	@Autowired
	private ApplicationContext applicationContext;
	 
	@Bean
	@ConfigurationProperties(prefix="spring.datasource.hikari")
	// application.properties의 설정 중 히카리에 관한 설정 가져오기
	public HikariConfig hikariConfig() {
		return new HikariConfig();
	}
	
	@Bean
	public DataSource dataSource() throws Exception{
		DataSource dataSource = new HikariDataSource(hikariConfig());
		System.out.println(dataSource.toString());
		return dataSource;
	}
	
	//-----------------------------------------------------------------------------------------------------
	
	@Bean
	@ConfigurationProperties(prefix="mybatis.configuration")
	// application.properties의 설정 중 마이바티스에 관한 설정 가져오기
	public org.apache.ibatis.session.Configuration mybatisConfig() {
		return new org.apache.ibatis.session.Configuration();
	}
	//-----------------------------------------------------------------------------------------------------
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mappers/**/*.xml"));
		// classpath는 resources폴더를 의미함
		// /mapper/는 mapper폴더 아래에 다른 폴더구조가 있는 설정
		// /sql-*.xml 이건 이름이 sql-로 시작하고 확장자가 xml인 모든 파일을 의미한다.
		sqlSessionFactoryBean.setConfiguration(mybatisConfig());
		return sqlSessionFactoryBean.getObject();
	}
	//-----------------------------------------------------------------------------------------------------
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	//------------------------------------------------------------------------------------------------------
	
	@ConfigurationProperties(prefix="spring.jpa")
	public Properties hibernateConfig() {
		return new Properties();
	}
	
	
	
	
	
	
}