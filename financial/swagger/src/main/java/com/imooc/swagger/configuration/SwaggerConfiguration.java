package com.imooc.swagger.configuration;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

/**
 * swagger 配置
 *
 * @author xiaozefeng
 * @date 2018/5/5 下午12:56
 */

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    private final SwaggerInfo swaggerInfo;

    @Autowired
    public SwaggerConfiguration(SwaggerInfo swaggerInfo) {
        this.swaggerInfo = swaggerInfo;
    }

    @Bean
    public Docket controllerApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .groupName(swaggerInfo.getGroupName())
                .apiInfo(apiInfo());
        ApiSelectorBuilder builder = docket.select();
        if (StringUtils.isNotBlank(swaggerInfo.getBasePackage())) {
            builder.apis(RequestHandlerSelectors.basePackage(swaggerInfo.getBasePackage()));
        }

        if (StringUtils.isNotBlank(swaggerInfo.getAntPath())) {
            builder.paths(PathSelectors.ant(swaggerInfo.getAntPath()));
        }
        return builder.build();
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(swaggerInfo.getTitle())
                .description(swaggerInfo.getDescription())
                .termsOfServiceUrl("http://springfox.io")
                .contact("imooc")
                .version("2.0")
                .build();
    }

}
