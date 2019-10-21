package com.wind.order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration // 让Spring来加载该类配置
@EnableSwagger2 // 启用Swagger2
public class Swagger2 {
    @Bean
    public Docket orderApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("ORDER接口文档").select()
                .apis(RequestHandlerSelectors.basePackage("com.wind.order")).paths(PathSelectors.any()).build();
    }
}
