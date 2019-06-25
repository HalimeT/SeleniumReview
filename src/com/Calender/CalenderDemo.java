package com.Calender;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import util.CommonMethods;

public class CalenderDemo extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		String url="https://jqueryui.com/datepicker/";
		setUpDriver("chrome",url);
		WebElement frame=driver.findElement(By.cssSelector("iframe.demo-frame"));
//		driver.switchTo().frame(frame);
		CommonMethods.switchToFrame(frame);
		driver.findElement(By.cssSelector("input#datepicker")).click();
		
		List<WebElement> cells=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
		System.out.println(cells.size());
		String expectedCell="27";
		for(WebElement cell:cells) {
			String cellText=cell.getText();
			if(cellText.equals(expectedCell)) {
			System.out.println(cellText+" is present");
				cell.click();
				break;
			}
		}
		Thread.sleep(5000);
		driver.quit();
		
	}

}
