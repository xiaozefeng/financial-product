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
public enum OrderStatusEnum {

    INIT(0, "初始"),
    PROCESS(1, "处理中"),
    SUCCESS(2, "成功"),
    FAIL(3, "失败"),;

    private Integer code;

    private String desc;


}
