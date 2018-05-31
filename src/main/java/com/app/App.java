package com.app;

import java.awt.EventQueue;

import com.bean.ApplicationConfiguration;
import com.view.MainFrame;

public class App {

	ApplicationConfiguration appConfig; 
	
	public static void main(String[] args) {
		App app = new App();
		app.setApplicationConfiguration();
		
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						MainFrame window = new MainFrame();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
	}
	
	private void setApplicationConfiguration() {
		try {
			appConfig = ApplicationConfiguration.getAppConfig();
			appConfig.setGoldCarat("20");
			appConfig.setGoldPricePerGm_18c(2564.00);
			appConfig.setGoldPricePerGm_20c(2978);
			appConfig.setGoldPricePerGm_22c(3675);
			appConfig.setSilverPricePerGm(750);
			appConfig.setMakingPerGmGold(300);
			appConfig.setMakingPerGmSilver(25);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
