package com.imooc.manager.service.impl;

import com.imooc.entity.Product;
import com.imooc.entity.enums.ProductStatusEnum;
import com.imooc.manager.repositories.ProductRepository;
import com.imooc.manager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author xiaozefeng
 * @date 2018/5/4 下午5:22
 */
@Service
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

    @Override
    public Page<Product> findAll(List<String> idList, BigDecimal minRewardRate, BigDecimal maxRewardRate, List<ProductStatusEnum> productStatusList, Pageable pageable) {

        return productRepository.findAll((root, query, cb) -> {
            Path<String> idCol = root.get("id");
            Path<BigDecimal> rewardRateCol = root.get("rewardRate");
            Path<ProductStatusEnum> statusCol = root.get("status");

            List<Predicate> predicates = new ArrayList<>();
            if (idList != null && idList.size() > 0) {
                predicates.add(idCol.in(idList));
            }
            if (BigDecimal.ZERO.compareTo(minRewardRate) < 0) {
                predicates.add(cb.ge(rewardRateCol, minRewardRate));
            }
            if (BigDecimal.ZERO.compareTo(maxRewardRate) < 0) {
                predicates.add(cb.le(rewardRateCol, maxRewardRate));
            }
            if (productStatusList != null && productStatusList.size() > 0) {
                predicates.add(statusCol.in(productStatusList));
            }
            query.where(predicates.toArray(new Predicate[0]));
            return null;
        }, pageable);
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

        Assert.isTrue(pattern.matcher(product.getStepAmount().toString()).matches(), "投资步长需要为整数");
    }
}
