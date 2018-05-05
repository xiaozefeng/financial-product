package com.imooc.entity;

import com.imooc.entity.enums.ProductStatusEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xiaozefeng
 */
@Entity
@Table(name = "tb_product")
@Data
public class Product implements Serializable {


    private static final long serialVersionUID = 3912484592911655134L;

    @Id
    private String id;

    /**
     * 产品名称
     */
    private String name;
    /**
     * 起投金额
     */
    private BigDecimal thresholdAmount;
    /**
     * 投资步长
     */
    private String stepAmount;
    /**
     * 锁定期
     */
    private Integer lockTerm;
    /**
     * 收益率 0-100 百分比
     */
    private BigDecimal rewardRate;
    /**
     * 产品状态: 销售中,锁定,已结束
     *
     * @see ProductStatusEnum
     */
    @ApiModelProperty(value = "产品状态", dataType = "com.imooc.entity.enums.ProductStatusEnum")
    @Enumerated(EnumType.STRING)
    private ProductStatusEnum status;
    /**
     * 备注
     */
    private String meno;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 更新时间
     */
    private Date updatedTime;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 最后更新人
     */
    private String updatedBy;


}