package br.com.fiap.checkpoint2.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info = @Info(
		title="Sprint 3",
		version="1.0",
		description="Projeto Challenge Scannia Sprint 3"
		))
public class SwaggerConfig {
	

}
