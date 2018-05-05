package com.imooc.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 产品状态
 *
 * @author xiaozefeng
 * @date 2018/5/4 下午5:05
 */
@Getter
@AllArgsConstructor
public enum ProductStatusEnum {
    AUDITING(0, "审核中"),
    ON_SELL(1, "销售中"),
    SUSPEND_SALES(2, "暂停销售"),
    FINISHED(3, "销售结束"),;

    private Integer code;

    private String desc;

}
