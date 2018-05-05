package com.imooc.manager.controller;

import com.imooc.entity.Product;
import com.imooc.entity.enums.ProductStatusEnum;
import com.imooc.manager.service.ProductService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 产品管理
 *
 * @author xiaozefeng
 * @date 2018/5/4 下午6:05
 */
@RequestMapping("/products")
@RestController
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 添加产品
     *
     * @param product
     * @return
     */
    @ApiOperation(value = "创建产品", notes = "根据对应的业务规则创建响应的产品")
    @PostMapping
    public Product addProject(@RequestBody Product product) {
        log.info("请求参数:{}", product);
        return productService.addProject(product);
    }


    /**
     * 根据id查询产品
     *
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Product getProduct(@PathVariable("id") String id) {
        return productService.findById(id);
    }


    @GetMapping
    public Page<Product> getAll(String ids,
                                BigDecimal minRewardRate,
                                BigDecimal maxRewardRate,
                                String statusList,
                                Pageable pageable) {
        log.info("查询产品: ids:{}, minRewardRate:{}, maxRewardRate:{}, statusList:{}, pageable:{}", ids, minRewardRate, maxRewardRate, statusList, pageable);
        List<String> idList = null;
        List<ProductStatusEnum> productStatusList = new ArrayList<>();
        if (StringUtils.isNotBlank(ids)) {
            idList = Arrays.asList(ids.split(","));
        }
        if (StringUtils.isNotBlank(statusList)) {
            Arrays.stream(statusList.split(","))
                    .map(ProductStatusEnum::valueOf)
                    .forEach(productStatusList::add);
        }

        return productService.findAll(idList,
                minRewardRate,
                maxRewardRate,
                productStatusList,
                pageable);
    }


}
