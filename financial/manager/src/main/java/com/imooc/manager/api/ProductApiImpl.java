package com.imooc.manager.api;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import com.imooc.api.ProductApi;
import com.imooc.api.dto.ProductRequest;
import com.imooc.entity.Product;
import com.imooc.manager.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * api实现
 *
 * @author xiaozefeng
 * @date 2018/5/5 下午3:37
 */
@AutoJsonRpcServiceImpl
@Service
@Slf4j
public class ProductApiImpl implements ProductApi {
    private ProductService productService;

    @Override
    public Page<Product> query(ProductRequest productRequest) {
        log.info("查询多个产品:{}", productRequest);
        return productService.findAll(productRequest.getIdList(),
                productRequest.getMinRewardRate(),
                productRequest.getMaxRewardRate(),
                productRequest.getProductStatusList(),
                productRequest.getPageable());
    }

    @Override
    public Product findById(String id) {
        log.info("查询单个产品,id:{}", id);
        return productService.findById(id);
    }
}
