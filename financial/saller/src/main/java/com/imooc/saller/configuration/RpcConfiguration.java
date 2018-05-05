package com.imooc.saller.configuration;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcClientProxyCreator;
import com.imooc.api.ProductApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author xiaozefeng
 * @date 2018/5/5 下午3:58
 */
@Configuration
@Slf4j
@ComponentScan(basePackages = "com.imooc.api")
public class RpcConfiguration {


    @Bean
    public AutoJsonRpcClientProxyCreator autoJsonRpcClientProxyCreator(@Value("${rpc.manager.url}")String url){
        AutoJsonRpcClientProxyCreator clientProxyCreator = new AutoJsonRpcClientProxyCreator();
        try {
            clientProxyCreator.setBaseUrl(new URL(url));
        } catch (MalformedURLException e) {
            log.error(e.getMessage(), e);
        }
        clientProxyCreator.setScanPackage(ProductApi.class.getPackage().getName());
        return clientProxyCreator;
    }
}
