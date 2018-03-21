package com.itheima.boot1.demo1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

@SpringBootApplication
//@MapperScan(basePackages = "com.itheima.boot1.demo1.mapper")
@EnableCaching
public class Demo1Application{
//	@Override  //extends SpringBootServletInitializer
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(Demo1Application.class);
//	}

	public static void main(String[] args) {

		SpringApplication.run(Demo1Application.class, args);
	}
	@Bean	//作用new一个对象，交给spring容器
	public MapperScannerConfigurer create(){
		MapperScannerConfigurer configurer = new MapperScannerConfigurer();
		configurer.setBasePackage("com.itheima.boot1.demo1.mapper");
		Properties properties = new Properties();
		properties.setProperty("mappers", "tk.mybatis.mapper.common.Mapper");
		configurer.setProperties(properties);
		return configurer;
	}

}
