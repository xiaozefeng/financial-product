package com.imooc.swagger.annotations;

import com.imooc.swagger.configuration.SwaggerConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启swagger 文档自动生成功能
 *
 * @author xiaozefeng
 * @date 2018/5/5 下午2:44
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(SwaggerConfiguration.class)
public @interface EnableMySwagger2 {
}
