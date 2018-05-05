package com.imooc.swagger.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * swagger 配置信息
 *
 * @author xiaozefeng
 * @date 2018/5/5 下午2:34
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "swagger")
public class SwaggerInfo {

    private String groupName = "controller";

    private String basePackage;

    private String antPath;

    private String title ="HTTP API";

    private String description = "管理端接口";

    private String license = "Apache License Version 2.0";
}
