package com.imooc.saller.service;

import com.google.common.collect.Lists;
import com.imooc.api.ProductApi;
import com.imooc.api.dto.ProductRequest;
import com.imooc.entity.Product;
import com.imooc.entity.enums.ProductStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author xiaozefeng
 * @date 2018/5/5 下午3:57
 */
@Service
public class ProductService {

    @Autowired
    private ProductApi productApi;


    public List<Product> findAll() {
        ProductRequest productRequest = new ProductRequest();
        productRequest.setProductStatusList(Lists.newArrayList(ProductStatusEnum.ON_SELL));
        return productApi.query(productRequest);
    }

    @PostConstruct
    public void test(){
        findAll();
    }
}
