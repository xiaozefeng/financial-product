package com.imooc.manager.controller;

import com.imooc.entity.Product;
import com.imooc.manager.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 产品管理
 *
 * @author xiaozefeng
 * @date 2018/5/4 下午6:05
 */
@RequestMapping("/product")
@RestController
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 添加产品
     * @param product
     * @return
     */
    @PostMapping
    public Product addProject(Product product) {
        log.info("请求参数:{}", product);
        return productService.addProject(product);
    }


    /**
     * 根据id查询产品
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Product getProduct(@PathVariable("id") String id) {
        return productService.findById(id);
    }







}
