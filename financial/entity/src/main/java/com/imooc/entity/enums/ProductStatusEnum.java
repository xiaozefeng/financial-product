package com.imooc.entity.enums;

import lombok.Getter;

/**
 * 产品状态
 *
 * @author xiaozefeng
 * @date 2018/5/4 下午5:05
 */
@Getter
public enum ProductStatusEnum {
    AUDITING(0, "审核中"),
    ON_SELL(1, "销售中"),
    SUSPEND_SALES(2, "暂停销售"),
    FINISHED(3, "销售结束"),
    ;

    private Integer code;

    private String desc;

    ProductStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
