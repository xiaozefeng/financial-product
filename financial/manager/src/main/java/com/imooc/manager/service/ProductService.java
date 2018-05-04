package com.imooc.manager.service;

import com.imooc.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 产品服务
 *
 * @author xiaozefeng
 * @date 2018/5/4 下午5:22
 */
public interface ProductService {

    /**
     * 添加产品
     *
     * @param product
     * @return
     */
    Product addProject(Product product);


    /**
     * 根据id 查询
     *
     * @param projectId
     * @return
     */
    Product findById(String projectId);

}
