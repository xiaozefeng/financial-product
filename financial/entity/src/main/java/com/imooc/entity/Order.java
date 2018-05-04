package com.imooc.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xiaozefeng
 */
@Data
@Entity
public class Order implements Serializable {

    private static final long serialVersionUID = 5755877074387678336L;

    /**
     * 订单编号
     */
    @Id
    private String orderId;
    /**
     * 套壳公司标号
     */
    private String chanId;
    /**
     * 产品id
     */
    private String productId;
    /**
     * 套壳公司的用户编号
     */
    private String chanUserId;
    /**
     * 申购:APPLY, 赎回:REDEEM
     */
    private String orderType;
    /**
     * 订单状态 INIT:初始化, PROCESS:处理中,SUCCESS:成功,FAIL:失败
     */
    private String orderStatus;
    /**
     * 外部订单编号
     */
    private String outOrderId;
    /**
     * 订单金额
     */
    private BigDecimal amount;
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


}