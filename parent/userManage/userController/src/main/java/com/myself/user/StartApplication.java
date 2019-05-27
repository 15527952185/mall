package com.myself.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.extern.log4j.Log4j2;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@Log4j2
@EnableTransactionManagement
@MapperScan(basePackages = "com.myself.mapper")	
public class StartApplication {	
	public static void main(String[] args) throws Exception {
		log.info("开始启动boot");
		ApplicationContext ac = SpringApplication.run(StartApplication.class, args);
	}
}
