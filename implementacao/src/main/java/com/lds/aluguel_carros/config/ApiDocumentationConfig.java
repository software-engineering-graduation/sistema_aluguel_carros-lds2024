package com.lds.aluguel_carros.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiDocumentationConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Sistema de aluguel de carros")
                        .version("0.0.1")
                        .description("API do sistema de aluguel de carros - Laboratório de Desenvolvimento de Software - 2024 - PUC Minas"));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("com.lds.aluguel_carros")
                .pathsToMatch("/**")
                .packagesToScan("com.lds.aluguel_carros")
                .build();
    }
}
