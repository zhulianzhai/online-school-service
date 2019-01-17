package com.liuxu.online;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
@ComponentScan("com.liuxu.online")
//@ImportResource({"classpath:/dubbo/dubbo-provider.xml"}) 
public class MeidianServiceOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeidianServiceOrderApplication.class, args);
		System.out.println("...............................................................");
		System.out.println("..................Service starts successfully..................");
		System.out.println("...............................................................");
	}
}
  