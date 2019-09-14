package com.hardcoders.havajack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication(scanBasePackages={"com.hardcoders.havajack"})
@EnableResourceServer
public class HavaJackApplication {

	public static void main(String[] args) {
		SpringApplication.run(HavaJackApplication.class, args);
	}

}
