package com.imooc.manager.service;

import com.imooc.entity.Product;
import com.imooc.entity.enums.ProductStatusEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
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


    /***
     * 根据条件查询产品信息
     * @param idList 多个产品id
     * @param minRewardRate 最小的收益率
     * @param maxRewardRate 最大的收益率
     * @param productStatusList 产品状态列表
     * @param pageable 分页信息
     * @return 一个包含产品的分页
     */
    Page<Product> findAll(List<String > idList,
                          BigDecimal minRewardRate,
                          BigDecimal maxRewardRate,
                          List<ProductStatusEnum> productStatusList,
                          Pageable pageable);

}
