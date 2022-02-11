package com.porto.store.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.porto.store.service.DBService;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired 
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}") 
	private String strategy;
	
	@Bean 
	public boolean instaciarBancoDeDados() {
		if(strategy.equals("create")) {
			this.dbService.instanciarBancoDeDados();
		}	
		return false;
	}
	

}
