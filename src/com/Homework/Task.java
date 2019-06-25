package com.Homework;


import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.CommonMethods;

public class Task{
	WebDriver driver;
	 WebElement element;
	String url="https://opensource-demo.orangehrmlive.com/";
	
@BeforeClass
public void navigate() {
	
	System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver");
	driver=new ChromeDriver();
	driver.manage().window().fullscreen();
	driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS );
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get(url);
	
  }   
   @Test(priority=1)
   public void login() {
	   driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	   driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	   driver.findElement(By.id("btnLogin")).click();
	   Assert.assertEquals(driver.findElement(By.cssSelector("a#welcome")).isDisplayed(), true);
	   System.out.println("Successfully login");
	  
	   
   }
   @Test(priority=2,enabled=false)
   public void AddEmployee() throws InterruptedException {
	   driver.findElement(By.id("menu_pim_viewPimModule")).click();
	   driver.findElement(By.id("menu_pim_addEmployee")).click();
	   driver.findElement(By.id("firstName")).sendKeys("Jonh");
	   driver.findElement(By.id("middleName")).sendKeys("J");
	   driver.findElement(By.id("lastName")).sendKeys("Smithh");
	   driver.findElement(By.id("employeeId")).clear();
	   driver.findElement(By.id("employeeId")).sendKeys("0100");
	  element= driver.findElement(By.name("photofile"));
	  element.sendKeys("/Users/betul/Desktop/finalphoto.png");
	  driver.findElement(By.id("chkLogin")).click();
	  driver.findElement(By.id("user_name")).sendKeys("jonhJS");
	  driver.findElement(By.id("user_password")).sendKeys("1234567890");
	  driver.findElement(By.id("re_password")).sendKeys("1234567890");
	  element=driver.findElement(By.id("status"));
	  Select select=new Select(element);
	  List<WebElement> status=driver.findElements(By.name("status"));
	  Iterator<WebElement>it=status.iterator();
	  while(it.hasNext()) {
		  WebElement e=it.next();
		 String text=e.getText();
		  if(text.equalsIgnoreCase("enable")) {
			  select.selectByVisibleText(text);
			 }
		  }
	  driver.findElement(By.id("btnSave")).click();
	  
	  Assert.assertEquals(driver.findElement(By.cssSelector("div#pdMainContainer")).isDisplayed(), true);  
	   System.out.println("Employee is added");
	   
   }	
   @Test(priority=3)
   public void EmployeeDetails() {
	   driver.findElement(By.id("menu_pim_viewPimModule")).click();
	   driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
	   driver.findElement(By.cssSelector("input#empsearch_id")).sendKeys("0100");
	   driver.findElement(By.cssSelector("input#searchBtn")).click();
	   element=driver.findElement(By.xpath("//table[@id='resultTable']/tbody//tr[@class='odd']"));
	   String text=element.getText();
	 
       Assert.assertEquals(text, "0100 Jonh J Smithh");
	   System.out.println("Employee details are displayed");
	   
   }
   @AfterClass
   public void logout() {
	   driver.close();
   }

}