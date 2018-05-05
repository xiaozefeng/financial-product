package com.imooc.manager.service.impl;

import com.imooc.entity.Product;
import com.imooc.entity.enums.ProductStatusEnum;
import com.imooc.manager.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 使用了内存数据测试代码
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
// 安装字母顺序执行单元测试
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class ProductServiceImplTest {

    @Autowired
    private ProductService productService;


    @Test
    public void addProject() {
        Product product = new Product();
        product.setId("001");
        product.setName("金融1号");
        product.setThresholdAmount(new BigDecimal("10"));
        product.setStepAmount("1");
        product.setLockTerm(0);
        product.setRewardRate(new BigDecimal("3.86"));
        product.setStatus(ProductStatusEnum.AUDITING);
        product.setMeno("测试");
        product.setCreatedTime(new Date());
        product.setUpdatedTime(new Date());
        product.setCreatedBy("admin");
        product.setUpdatedBy("admin");
        Product result = productService.addProject(product);
        Assert.assertNotNull(result);
        log.info("{}", result);

    }

    @Test
    public void b_findById() {
        Product product = productService.findById("001");
        log.info("{}", product);
        Assert.assertNotNull(product);
    }

    @Test
    public void c_findAll() {
    }
}