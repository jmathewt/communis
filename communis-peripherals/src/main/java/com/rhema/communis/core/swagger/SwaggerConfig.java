package com.rhema.communis.core.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private List<Parameter> listDocketParameters;

    public SwaggerConfig() {

        //Any parameter or header you want to require for all end_points
        Parameter oAuthHeader = new ParameterBuilder()
                .name("X-Auth-Token")
                .description("JWT Token")
                .defaultValue("YourJWTTokenHere")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(true)
                .build();

        this.listDocketParameters = new ArrayList<Parameter>();
        this.listDocketParameters.add(oAuthHeader);
    }


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(listDocketParameters)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.rhema"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Communis")
                .description("The REST API for communis services.").termsOfServiceUrl("")
                .contact(new Contact("ROBIN VARGHESE", "", "robinvk6@gmail.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .version("0.0.1")
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("authkey", "X-Auth-Token", "header");
    }
}
