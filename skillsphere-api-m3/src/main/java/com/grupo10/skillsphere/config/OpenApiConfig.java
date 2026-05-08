package com.grupo10.skillsphere.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración de OpenAPI (Swagger) para documentar la API.
 * Esta clase genera la documentación automática de los endpoints,
 * permitiendo descargar el JSON para Postman y visualizar en Swagger UI.
 */
@Configuration
public class OpenApiConfig {

    /**
     * Bean que configura la información general de la API.
     * Define título, descripción, versión y contacto para la documentación.
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("SkillSphere API") // Título de la API
                        .description("API REST para la plataforma SkillSphere: gestión de estudiantes, certificados y ofertas laborales. " +
                                "Permite consultar y crear recursos de manera estructurada.") // Descripción del propósito
                        .version("1.0.0") // Versión de la API
                        .contact(new Contact()
                                .name("Equipo SkillSphere") // Contacto
                                .email("skillsphere@grupo10.com"))); // Email de contacto
    }
}