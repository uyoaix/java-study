package com.study.yufei.json;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * 用户账户变动明细
 * @Author caochangshan
 * @Date 2020/3/30
 **/
@Data
public class AcctAccountFlow {

    private Long id;

    private Long userId;

    private Integer linkType;

    private String linkNo;

    private String orderNo;

    private String currency;

    private BigDecimal amount;

    private Integer type;

    private String remarks;

    private Boolean isDeleted;

    private Date createTime;

    private Date updateTime;

    /**
     * 非数据库字段，账户变动（格式key：2001、3001 ,value扣减金额）
     */
    private Map<String, BigDecimal> productMap;

}
