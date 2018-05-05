package com.imooc.manager.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger 配置
 *
 * @author xiaozefeng
 * @date 2018/5/5 下午12:56
 */
@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket controllerApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("controller")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.imooc.manager.controller"))
                .build();
    }

    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("HTTP API")
                .description("管理端接口")
                .termsOfServiceUrl("http://springfox.io")
                .contact("imooc")
                .version("2.0")
                .build();
    }

}
