package com.business;

public class Compute {

	public double caluclateItemAmountPerGm(double weight, double ratePerGm,double makingPerGm,double makingPerPc, int qty, boolean makingPerGmEnabled) {
		double amount=0;
		if(makingPerGmEnabled) {
			amount=((ratePerGm*weight)+(makingPerGm*weight))*qty;
		}else {
			amount = ((ratePerGm*weight)+makingPerPc)*qty;
		}
		return amount;
	}
	
	public double calculateItemAmountPerPc(double pricePerPc,double makingPerPc, double qty) {
		return (pricePerPc+makingPerPc)*qty;
	}
}
