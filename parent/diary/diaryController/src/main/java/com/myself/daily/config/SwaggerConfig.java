package com.myself.daily.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Value("${swagger.show}")
	private boolean externallyConfiguredFlag;
    @Bean
    public Docket createRestApi(){
    	ApiSelectorBuilder apiSelectorBuilder = new Docket(DocumentationType.SWAGGER_2)
		.enable(externallyConfiguredFlag)
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("com"))
        .paths(PathSelectors.any());
        return apiSelectorBuilder.build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("Spring Boot中使用Swagger构建Rest Api")
                .version("1.0").build();
    }
}