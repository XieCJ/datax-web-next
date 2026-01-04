package com.wugui.datax.admin.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * SpringDoc OpenAPI文档配置
 * Created by jwk on 2019/07/05.
 * Updated for SpringDoc OpenAPI (2024)
 */
@Configuration
@ConditionalOnWebApplication
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("DataX Web API Docs")
                        .version("2.1.2")
                        .description("DataX Web管理平台API文档"));
    }
}
