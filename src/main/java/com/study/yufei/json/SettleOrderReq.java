package com.study.yufei.json;

import lombok.Data;

import java.math.BigDecimal;


/**
 * 订单结算（终态）
 **/
public class SettleOrderReq {
    /**
     * 关联类型:1游戏 2赛事 3活动
     */
    private Integer linkType;

    /**
     * 关联编号：1关联game_info表no字段(游戏编号)  2比赛id
     */
    private String linkNo;

    private String orderNo;

    private BigDecimal betAmount;

    private BigDecimal award;

    /**
     * 有效投币额
     */
    private BigDecimal validBetAmount;

    private Long userId;

    private String currency;

    public Integer getLinkType() {
        return linkType;
    }

    public void setLinkType(Integer linkType) {
        this.linkType = linkType;
    }

    public String getLinkNo() {
        return linkNo;
    }

    public void setLinkNo(String linkNo) {
        this.linkNo = linkNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public BigDecimal getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(BigDecimal betAmount) {
        this.betAmount = betAmount;
    }

    public BigDecimal getAward() {
        return award;
    }

    public void setAward(BigDecimal award) {
        this.award = award;
    }

    public BigDecimal getValidBetAmount() {
        return validBetAmount;
    }

    public void setValidBetAmount(BigDecimal validBetAmount) {
        this.validBetAmount = validBetAmount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}

