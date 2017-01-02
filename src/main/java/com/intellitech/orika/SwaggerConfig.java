package com.intellitech.orika;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
        	.useDefaultResponseMessages(false)
            .select()
            .apis(RequestHandlerSelectors.any())
            .apis(RequestHandlerSelectors.basePackage("com.intellitech.orika.controller"))
            .paths(paths())
            .build()
            .apiInfo(apiInfo());
    }
	
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Orika with spring integration")
            .description("Created by ayman ben amor")
            .version("1.0")
            .termsOfServiceUrl("http://terms-of-services.url")
            .license("Apache License Version 2.0")
            .licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
            .build();
    }
	
	@SuppressWarnings("unchecked")
	private Predicate<String> paths(){
		return or(
				regex("/users.*"),
				regex("/users.*")
				);
	}
}
