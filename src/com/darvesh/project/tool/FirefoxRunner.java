package com.darvesh.project.tool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxRunner extends TestCaseRunner{

	public void RunTest(String url, String runDate) throws InterruptedException{
		String browserName= "Firefox";
		System.setProperty("webdriver.gecko.driver", "D:\\driver\\geckodriver.exe");
		/*File pathBinary = new File("E:\\Program Files\\firefox\\firefox.exe");
		FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();*/       
		//WebDriver driver = new FirefoxDriver(firefoxBinary, firefoxProfile);
		WebDriver driver = new FirefoxDriver();
		driver.get(url);
		Thread.sleep(3000);
		this.fillData(driver);
		Thread.sleep(2000);
		this.takeScreenShot(browserName, driver, runDate);
		Thread.sleep(5000); 
        driver.quit();
	}
}
