package br.com.frsiqueira.challengebackend.dto;

import java.math.BigDecimal;

public class Dimension {

    private BigDecimal weight;
    private BigDecimal height;
    private BigDecimal widt;
    private BigDecimal length;

    public Dimension(BigDecimal weight, BigDecimal height, BigDecimal widt, BigDecimal length) {
        this.weight = weight;
        this.height = height;
        this.widt = widt;
        this.length = length;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public BigDecimal getWidt() {
        return widt;
    }

    public BigDecimal getLength() {
        return length;
    }




}

