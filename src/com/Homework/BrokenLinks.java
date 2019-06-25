package com.Homework;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {
	WebDriver driver;

	@BeforeMethod
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver");
	    driver=new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.get("http://newtours.demoaut.com/");
	}
	
	@Test
	public void brokenLinks() {
		List<WebElement> links=driver.findElements(By.tagName("a"));
		for(WebElement link:links) {
			String linkText=link.getAttribute("href");
			try {
				URL url=new URL(linkText);
				HttpURLConnection conn=(HttpURLConnection)url.openConnection();
				int code=conn.getResponseCode();
			   
				if(code==200) {
				System.out.println(link.getText()+ " is valid link");
			    }else {
				System.out.println("Invalid link");
			    }
				
			 }catch(Exception e) {
				e.printStackTrace();
			  }
		   }
		}
	@AfterMethod
	public void close() {
		driver.close();
	}
	

}
