package com.vendas.vendas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class VendasApplication {
	@Autowired
	private Environment env;
	@GetMapping("/")
	public String getAmbiente(){
		String ambienteAtual = "Padrão (nenhum)";
		if (env.getActiveProfiles().length > 0){
		 ambienteAtual = env.getActiveProfiles()[0];
		}
		String appName = env.getProperty("spring.application.name");
		return String.format("Ambiente: %s | App Name: %s", ambienteAtual, appName);
	}
	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
