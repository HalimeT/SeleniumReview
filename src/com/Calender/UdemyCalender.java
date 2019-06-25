package com.Calender;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import util.CommonMethods;

public class UdemyCalender extends CommonMethods {

	public static void main(String[] args) {
		String url="https://www.path2usa.com/travel-companions";
		setUpDriver("chrome",url);
		//June 14
		driver.findElement(By.id("travel_date")).click();
		WebElement month=driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']"));
		
		while(!month.getText().contains("June")) {
			driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next']")).click();
		
			}
	
		
		List<WebElement >dates=driver.findElements(By.cssSelector(".day"));
		int count=dates.size();
		
		for(int i=0; i<count; i++) {
			WebElement date=dates.get(i);
			
			String text=date.getText();
			
			if(text.equalsIgnoreCase("14")) {
				date.click();
				System.out.println(text);
				break;
			}
		}
		
		

	}

}
