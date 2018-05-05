package com.imooc.api;

import com.googlecode.jsonrpc4j.JsonRpcService;
import com.imooc.api.dto.ProductRequest;
import com.imooc.entity.Product;
import org.springframework.data.domain.Page;

/**
 * @author xiaozefeng
 * @date 2018/5/5 下午3:30
 */
@JsonRpcService("/products")
public interface ProductApi {

    /**
     * 查询多个产品
     * @return
     */
    Page<Product> query(ProductRequest productRequest);

    /**
     * 根据产品id查询产品信息
     * @param id
     * @return
     */
    Product findById(String id);
}
