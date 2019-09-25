package com.ts.module.stock.model;

import java.io.Serializable;
import java.util.Date;

public class StockProfit implements Serializable{
	private static final long serialVersionUID = 1L;
	private String MD5;
    private String stockCode;
    private String stockName;
    private String buyTotal;
    private String stockCost;
    private String sellTotal;
    private String stockDeal;
    private String dealNumber;
    private String dealDate;
    private String stockProfit;
    private String stockNetProfit;
    private String taxAmount;
    private String addPersonCode;
    private String addPerson;
    private String addDate;
    private String alterPersonCode;
    private String alterPerson;
    private String alterDate;
    
	public String getMD5() {
		return MD5;
	}
	public void setMD5(String mD5) {
		MD5 = mD5;
	}
	public String getStockCode() {
		return stockCode;
	}
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public String getBuyTotal() {
		return buyTotal;
	}
	public void setBuyTotal(String buyTotal) {
		this.buyTotal = buyTotal;
	}
	public String getStockCost() {
		return stockCost;
	}
	public void setStockCost(String stockCost) {
		this.stockCost = stockCost;
	}
	public String getSellTotal() {
		return sellTotal;
	}
	public void setSellTotal(String sellTotal) {
		this.sellTotal = sellTotal;
	}
	public String getStockDeal() {
		return stockDeal;
	}
	public void setStockDeal(String stockDeal) {
		this.stockDeal = stockDeal;
	}
	public String getDealNumber() {
		return dealNumber;
	}
	public void setDealNumber(String dealNumber) {
		this.dealNumber = dealNumber;
	}
	public String getDealDate() {
		return dealDate;
	}
	public void setDealDate(String dealDate) {
		this.dealDate = dealDate;
	}
	public String getStockProfit() {
		return stockProfit;
	}
	public void setStockProfit(String stockProfit) {
		this.stockProfit = stockProfit;
	}
	public String getStockNetProfit() {
		return stockNetProfit;
	}
	public void setStockNetProfit(String stockNetProfit) {
		this.stockNetProfit = stockNetProfit;
	}
	public String getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(String taxAmount) {
		this.taxAmount = taxAmount;
	}
	public String getAddPersonCode() {
		return addPersonCode;
	}
	public void setAddPersonCode(String addPersonCode) {
		this.addPersonCode = addPersonCode;
	}
	public String getAddPerson() {
		return addPerson;
	}
	public void setAddPerson(String addPerson) {
		this.addPerson = addPerson;
	}
	public String getAddDate() {
		return addDate;
	}
	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}
	public String getAlterPersonCode() {
		return alterPersonCode;
	}
	public void setAlterPersonCode(String alterPersonCode) {
		this.alterPersonCode = alterPersonCode;
	}
	public String getAlterPerson() {
		return alterPerson;
	}
	public void setAlterPerson(String alterPerson) {
		this.alterPerson = alterPerson;
	}
	public String getAlterDate() {
		return alterDate;
	}
	public void setAlterDate(String alterDate) {
		this.alterDate = alterDate;
	}
    
	
    
    
}
