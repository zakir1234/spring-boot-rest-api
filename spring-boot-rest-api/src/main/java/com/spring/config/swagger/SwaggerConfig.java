/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 *
 * @author zakir
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
   
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.spring"))
                .build()
                .apiInfo(metaData());
    }
    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfoBuilder()
        
        		.title("Spring Boot Rest API")
                .description("Spring Boot Rest API Template with oauth2 jwt \n"
                        + "<b style='font-size: large;color: cornflowerblue;'>Md. Zakir Hossain (Java Developer) </b>")
                .version("4.0.0")
                .contact(new Contact("Md. Zakir Hossain", "www.mbbsnet.com:5656", "zakirho857@gmail.com"))
                .build();        	
        return apiInfo;
    }
}
