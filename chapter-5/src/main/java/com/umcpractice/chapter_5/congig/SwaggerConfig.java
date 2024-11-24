package com.umcpractice.chapter_5.congig;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    private String version = "1.0.0";

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().addServersItem(new Server().url("/"))
                .components(new Components().addSecuritySchemes("access-token",
                        new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .in(SecurityScheme.In.HEADER)
                                .name("Authorization")
                                .scheme("bearer")
                                .bearerFormat("JWT")))
                .info(apiInfo())
                .tags(tagList());
    }

    private io.swagger.v3.oas.models.info.Info apiInfo() {
        return new Info()
                .title("UMC Server WorkBook API")
                .description("UMC Server WorkBook API 명세서")
                .version(version);
    }

    private List<Tag> tagList() {
        return List.of(
                new Tag().name("Auth").description("인증 관련 API")
        );
    }
}