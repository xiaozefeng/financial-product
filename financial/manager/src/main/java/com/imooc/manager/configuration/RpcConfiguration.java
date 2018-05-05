package com.imooc.manager.configuration;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImplExporter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaozefeng
 * @date 2018/5/5 下午3:40
 */
@Configuration
public class RpcConfiguration {

    @Bean
    public AutoJsonRpcServiceImplExporter rpcServiceImplExporter(){
        return new AutoJsonRpcServiceImplExporter();
    }
}
