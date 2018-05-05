package com.imooc.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 订单类型
 *
 * @author xiaozefeng
 * @date 2018/5/4 下午5:10
 */
@Getter
@AllArgsConstructor
public enum OrderTypeEnum {

    APPLY(0, "申购"),
    REDEEM(1, "赎回"),;

    private Integer code;

    private String desc;


}
