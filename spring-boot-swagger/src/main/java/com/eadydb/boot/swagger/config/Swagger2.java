package com.eadydb.boot.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.RequestHandlerProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by dengbin on 16-11-14.
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createDocketApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.eadydb.boot.swagger"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot与Swagger2构建RESTful APIs")
                .description("spring boot 项目集成")
                .termsOfServiceUrl("https://github.com/eadydb/spring-boot-example")
                .contact(new Contact("eadydb", "", "dengbin1201@163.com"))
                .version("1.0")
                .build();
    }
}
