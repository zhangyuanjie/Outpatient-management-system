package com.zyj.hos.entity;

public class Drug {
    private Integer drugId;
    private String drugName;
    private String drugType;
    private String drugSpecification;
    private String drugWay;
    private String drugFunction;
    private Integer drugStock;
    private String drugUnit;
    private String drugPrice;
    private String drugTime;
    private String drugProvider;

    public Drug() {
    }

    public Drug(Integer drugId, String drugName, String drugType, String drugSpecification, String drugWay, String drugFunction, Integer drugStock, String drugUnit, String drugPrice, String drugTime, String drugProvider) {
        this.drugId = drugId;
        this.drugName = drugName;
        this.drugType = drugType;
        this.drugSpecification = drugSpecification;
        this.drugWay = drugWay;
        this.drugFunction = drugFunction;
        this.drugStock = drugStock;
        this.drugUnit = drugUnit;
        this.drugPrice = drugPrice;
        this.drugTime = drugTime;
        this.drugProvider = drugProvider;
    }

    public String getDrugType() {
        return drugType;
    }

    public void setDrugType(String drugType) {
        this.drugType = drugType;
    }

    public Integer getDrugId() {
        return drugId;
    }

    public void setDrugId(Integer drugId) {
        this.drugId = drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDrugSpecification() {
        return drugSpecification;
    }

    public void setDrugSpecification(String drugSpecification) {
        this.drugSpecification = drugSpecification;
    }

    public String getDrugWay() {
        return drugWay;
    }

    public void setDrugWay(String drugWay) {
        this.drugWay = drugWay;
    }

    public String getDrugFunction() {
        return drugFunction;
    }

    public void setDrugFunction(String drugFunction) {
        this.drugFunction = drugFunction;
    }

    public Integer getDrugStock() {
        return drugStock;
    }

    public void setDrugStock(Integer drugStock) {
        this.drugStock = drugStock;
    }

    public String getDrugUnit() {
        return drugUnit;
    }

    public void setDrugUnit(String drugUnit) {
        this.drugUnit = drugUnit;
    }

    public String getDrugPrice() {
        return drugPrice;
    }

    public void setDrugPrice(String drugPrice) {
        this.drugPrice = drugPrice;
    }

    public String getDrugTime() {
        return drugTime;
    }

    public void setDrugTime(String drugTime) {
        this.drugTime = drugTime;
    }

    public String getDrugProvider() {
        return drugProvider;
    }

    public void setDrugProvider(String drugProvider) {
        this.drugProvider = drugProvider;
    }
}
