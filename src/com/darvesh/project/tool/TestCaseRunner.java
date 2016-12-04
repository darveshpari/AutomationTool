package com.darvesh.project.tool;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class TestCaseRunner {
	
	public static void main(String[] args) throws InterruptedException {
		String runDate = getCurrentDate();
		String url = "file:///D:/GradeCalculator/GradeCalculator.html";
		FirefoxRunner firefox = new FirefoxRunner();
		firefox.RunTest(url,runDate);
		Thread.sleep(5000);
		ChromeRunner chrome = new ChromeRunner();
		chrome.RunTest(url,runDate);
		Thread.sleep(5000);
		EdgeRunner eRunner = new EdgeRunner();
		eRunner.RunTest(url,runDate);
 
	}

	protected void fillData(final WebDriver driver) throws InterruptedException {
		driver.manage().window().maximize();
		Thread.sleep(1000);
		WebElement textBox = driver.findElement(By.name("category[]"));
		textBox.sendKeys("Assignments");
		Thread.sleep(1000); 
		textBox = driver.findElement(By.name("weights[]"));
		textBox.sendKeys("40");
		Thread.sleep(1000);
		textBox = driver.findElement(By.name("create123"));  
		if (driver instanceof EdgeDriver) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", textBox);
		} else {
			textBox.click();
		}
	}

	protected void takeScreenShot(final String browserName,
			final WebDriver driver, final String runDate) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		StringBuilder path = new StringBuilder();
		path.append("D:/Selenium snapshot/").append(browserName).append("_").append(runDate)
				.append("_snapshot.png");
		try {
			FileUtils.copyFile(src, new File(path.toString()));
		} catch (IOException e) {
			System.out.println(e.getMessage());

		}
	}
	
	private static String getCurrentDate(){
		Date date = new Date(); 
		SimpleDateFormat simpleFormat = new SimpleDateFormat("MMddyyhhmmss");
		return simpleFormat.format(date);
	}
}
