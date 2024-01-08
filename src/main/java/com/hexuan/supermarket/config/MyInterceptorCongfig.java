package com.hexuan.supermarket.config;


import com.hexuan.supermarket.interceptor.JwtValidateInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.service.contexts.SecurityContext;

import java.util.Collections;
import java.util.List;

/**
 * @Author hexuan
 * @Date 2023/8/29 0:40
 * @PackageName:com.hexuan.config
 * @ClassName: MyInterceptorCongfig
 * @Description: TODO
 */

@Configuration
public class MyInterceptorCongfig implements WebMvcConfigurer {

    @Autowired
    private JwtValidateInterceptor jwtValidateInterceptor;

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


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(jwtValidateInterceptor);
        registration.addPathPatterns("/**")
                .excludePathPatterns(
                        "/user/login",
                        "/user/info",
                        "/user/loginOut",
                        "/error",
                        "/swagger-ui/**",
                        "/swagger-resources/**",
                        "/v3/**",
                        "/shop/getShopListByShopTypeId"
                );


        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
