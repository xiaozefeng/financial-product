package com.imooc.api;

import com.googlecode.jsonrpc4j.JsonRpcService;
import com.imooc.api.dto.ProductRequest;
import com.imooc.entity.Product;

import java.util.List;

/**
 * @author xiaozefeng
 * @date 2018/5/5 下午3:30
 */
@JsonRpcService("rpc/products")
public interface ProductApi {

    /**
     * 查询多个产品
     * @return
     */
    List<Product> query(ProductRequest productRequest);

    /**
     * 根据产品id查询产品信息
     * @param id
     * @return
     */
    Product findById(String id);
}
