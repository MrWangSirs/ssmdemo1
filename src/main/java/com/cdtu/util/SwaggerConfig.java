package com.cdtu.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by DCLab on 12/17/2015.
 */
@Configuration
@EnableWebMvc //NOTE: Only needed in a non-springboot application
@EnableSwagger2 //Enable swagger 2.0 spec
@ComponentScan("com.cdtu.controller")
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cdtu.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("RESTful API Docs Of UserCenter")
                .description("RESTful API Docs")
                .termsOfServiceUrl("http://uc.ssmdemo.com/")
                .contact("jingxiao")
                .version("1.0")
                .build();
    }
}