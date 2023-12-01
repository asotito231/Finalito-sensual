package com.kaeser.platform.u202116113.shared.infrastructure.documentation.openapi.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI ISAOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Kaeser")
                        .description("Kaeser REST API documentation.")
                        .version("v1.0.0")
                        .contact(new io.swagger.v3.oas.models.info.Contact().name("SOTO"))
                        .license(new License().name("Apache 2.0")
                                .url("https://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Kaeser Documentation")
                        .url("https://www.kaeser.com/int-en"));
    }
}
