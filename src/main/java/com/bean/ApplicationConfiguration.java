package com.bean;

public class ApplicationConfiguration {

	private static ApplicationConfiguration appConfig;
	private ApplicationConfiguration() {
		
	}
	
	public static ApplicationConfiguration getAppConfig() {
		if(null == appConfig) {
			synchronized(ApplicationConfiguration.class){
				if(null==appConfig) {
					appConfig = new ApplicationConfiguration();
				}
			}
		}
		return appConfig;
	}
	
	String goldCarat;
	double goldPricePerGm_18c;
	double goldPricePerGm_20c;
	double goldPricePerGm_22c;
	double silverPricePerGm;
	double makingPerGmSilver;
	double makingPerGmGold;
	
	public String getGoldCarat() {
		return goldCarat;
	}

	public void setGoldCarat(String goldCarat) {
		this.goldCarat = goldCarat;
	}

	public double getGoldPricePerGm_18c() {
		return goldPricePerGm_18c;
	}

	public void setGoldPricePerGm_18c(double goldPricePerGm_18c) {
		this.goldPricePerGm_18c = goldPricePerGm_18c;
	}

	public double getGoldPricePerGm_20c() {
		return goldPricePerGm_20c;
	}

	public void setGoldPricePerGm_20c(double goldPricePerGm_20c) {
		this.goldPricePerGm_20c = goldPricePerGm_20c;
	}

	public double getGoldPricePerGm_22c() {
		return goldPricePerGm_22c;
	}

	public void setGoldPricePerGm_22c(double goldPricePerGm_22c) {
		this.goldPricePerGm_22c = goldPricePerGm_22c;
	}

	public double getSilverPricePerGm() {
		return silverPricePerGm;
	}

	public void setSilverPricePerGm(double silverPricePergm) {
		this.silverPricePerGm = silverPricePergm;
	}

	public double getMakingPerGmSilver() {
		return makingPerGmSilver;
	}

	public void setMakingPerGmSilver(double makingPerGmSilver) {
		this.makingPerGmSilver = makingPerGmSilver;
	}

	public double getMakingPerGmGold() {
		return makingPerGmGold;
	}

	public void setMakingPerGmGold(double makingPerGmGold) {
		this.makingPerGmGold = makingPerGmGold;
	}
	
}
