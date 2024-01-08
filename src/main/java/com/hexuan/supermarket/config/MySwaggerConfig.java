package com.hexuan.supermarket.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
import java.util.List;
/**
 * @Author hexuan
 * @Date 2023/8/29 9:51
 * @PackageName:com.hexuan.config
 * @ClassName: MySwaggerConfig
 * @Description: TODO
 */

@Configuration
@EnableOpenApi
@EnableWebMvc
public class MySwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hexuan"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(Collections.singletonList(securityScheme())) //在swagger添加认证处理
                .securityContexts(Collections.singletonList(securityContext()));
    }

    private SecurityScheme securityScheme() {
        return new ApiKey("Authorization", "Authorization", "header");
//        return new ApiKey("Elm-Token", "Elm-Token", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("^(?!auth).*$"))
                .build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Collections.singletonList(
                new SecurityReference("Authorization", authorizationScopes));
    }

// 注意访问要加elm   http://localhost:8080/elm/swagger-ui/index.html
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("何璇小型商超系统")
                .description("何璇20211120061软件工程-软件设计与体系结构大作业")
                .version("1.0")
                .contact(new Contact("何璇", "https://mail.qq.com/", "1402050127@qq.com"))
                .build();
    }
}
