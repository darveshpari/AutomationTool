package com.darvesh.project.tool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeRunner extends TestCaseRunner {

	public void RunTest(String url, String runDate) throws InterruptedException {
		String browserName = "Chrome";
		System.setProperty("webdriver.chrome.driver",
				"D:\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		Thread.sleep(3000);
		this.fillData(driver);
		Thread.sleep(2000);
		this.takeScreenShot(browserName, driver, runDate);
		Thread.sleep(5000); 
		driver.quit();
	}
}
