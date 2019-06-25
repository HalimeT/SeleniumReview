package SeleniumReview;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownUitest {

	public static void main(String[] args) throws InterruptedException {
//		Open chrome browser
		System.setProperty("webdriver.chrome.driver", "/Users/betul/Selenium/chromedriver");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
//		Go to “http://uitestpractice.com/”
		driver.get("http://uitestpractice.com/");
//		Click on “Select” tab
		driver.findElement(By.partialLinkText("Select")).click();

		Select obj;
		List<WebElement>list;
//		Verify how many options available in the first drop down and then select “United states of America”
		WebElement country=driver.findElement(By.id("countriesSingle"));
		obj=new Select(country);
		list=obj.getOptions();
		System.out.println(list.size());
	//	obj.selectByVisibleText("United states of America");
		obj.selectByValue("usa");
		
//		Verify how many options available in the second drop down and then select all.
		WebElement countries=driver.findElement(By.id("countriesMultiple"));
		obj=new Select(countries);
		list=obj.getOptions();
		System.out.println(list.size());
		System.out.println();
		 Iterator<WebElement> it=list.iterator();
		 while(it.hasNext()) {
			 WebElement str=it.next();
					 str.click();
					 String s=str.getText();
			 System.out.println(s);
		 }
//		Deselect China from the second drop down
		 obj.deselectByVisibleText("China");
//		Quit browser (edited) 
		 driver.quit();
		
		

		 }
		 }


