package com.darvesh.project.tool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class EdgeRunner extends TestCaseRunner {
	
	
	public void RunTest(String url, String runDate) throws InterruptedException {
		String browserName = "Edge";
		System.setProperty("webdriver.edge.driver",
				"D:\\driver\\MicrosoftWebDriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.edge();
		WebDriver driver = new EdgeDriver(capabilities);
		driver.get(url);
		Thread.sleep(3000);
		this.fillData(driver);
		Thread.sleep(2000);
		this.takeScreenShot(browserName, driver, runDate);
		Thread.sleep(5000); 
		driver.quit();
	}

}
