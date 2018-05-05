package com.imooc.api.dto;

import com.imooc.entity.enums.ProductStatusEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author xiaozefeng
 * @date 2018/5/5 下午3:32
 */
@Getter
@Setter
@ToString
public class ProductRequest implements Serializable {

    private static final long serialVersionUID = -8275987183144511421L;

    private List<String> idList;
    private BigDecimal minRewardRate;
    private BigDecimal maxRewardRate;
    private List<ProductStatusEnum> productStatusList;
    private Pageable pageable;
}
