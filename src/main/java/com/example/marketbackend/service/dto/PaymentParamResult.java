package com.example.marketbackend.service.dto;

import com.example.marketbackend.entity.MarketBase;
import com.example.marketbackend.entity.PaymentList;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class PaymentParamResult {
    private Long productId;
    private String productName;
    private Integer quantity;
    private BigDecimal currentPrice;
    private BigDecimal sum;

    public PaymentParamResult(Long productId, String productName, Integer quantity, BigDecimal currentPrice, BigDecimal sum) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.currentPrice = currentPrice;
        this.sum = sum;
    }

    public PaymentParamResult(PaymentList paymentList, MarketBase marketBase) {
        this.productId = paymentList.getProduct().getId();
        this.productName = paymentList.getProduct().getName();
        this.quantity = paymentList.getQuantity();
        this.currentPrice = marketBase.getCurrentPrice();
        this.sum = marketBase.getCurrentPrice().multiply(new BigDecimal("" + paymentList.getQuantity()));
    }

    public PaymentParamResult(MarketBase marketBase) {
        this.productId = marketBase.getProduct().getId();
        this.productName = marketBase.getProduct().getName();
        this.quantity = marketBase.getQuantity();
        this.currentPrice = marketBase.getCurrentPrice();
        this.sum = marketBase.getCurrentPrice();
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }
}
