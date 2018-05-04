package com.imooc.manager.service.impl;

import com.imooc.entity.Product;
import com.imooc.entity.enums.ProductStatusEnum;
import com.imooc.manager.repositories.ProductRepository;
import com.imooc.manager.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * @author xiaozefeng
 * @date 2018/5/4 下午5:22
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    Pattern pattern = Pattern.compile("[0-9]*");

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProject(Product product) {
        check(product);
        product.setCreatedBy("admin");
        product.setUpdatedBy("admin");
        product.setStatus(ProductStatusEnum.AUDITING);
        product.setCreatedTime(new Date());
        product.setUpdatedTime(new Date());
        // 数据校验
        // 设置默认值
        productRepository.save(product);
        return product;
    }

    @Override
    public Product findById(String projectId) {
        return productRepository.findOne(projectId);
    }

    /**
     * 数据校验
     * 1. 非空数据
     * 2. 收益要0 -30 以内
     * 3. 投资步长为整数
     *
     * @param product
     */
    private void check(Product product) {
        Assert.notNull(product.getId(), "编号不能为空");

        BigDecimal rewardRate = product.getRewardRate();
        Assert.isTrue(BigDecimal.ZERO.compareTo(rewardRate) > 0 &&
                rewardRate.compareTo(BigDecimal.valueOf(30)) <= 0, "收益率范围为 0~30");

        Assert.isTrue(pattern.matcher(product.getStepAmount().toString()).matches(), "投资步长需要为整数");
    }
}
