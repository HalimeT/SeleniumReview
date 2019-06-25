package SeleniumReview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class cssSelectorFaceBook {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/betul/Selenium/chromedriver");
		WebDriver driver =new ChromeDriver();
		driver.navigate().to("https://www.facebook.com/");
		driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("Mahri");
		driver.findElement(By.cssSelector("input[name^='last']")).sendKeys("Temaks");
		driver.findElement(By.cssSelector("input[name^='reg']")).sendKeys("tester123@gmail.com");
		driver.findElement(By.cssSelector("input[data-type$='ord']")).sendKeys("1234qwe");
		driver.findElement(By.cssSelector("select[title$='nth']")).sendKeys("July");
		driver.findElement(By.cssSelector("select[id$='y']")).sendKeys("9");
		driver.findElement(By.cssSelector("select[id*='ea']")).sendKeys("2000");
		driver.findElement(By.cssSelector("#u_0_a")).click();
		driver.findElement(By.cssSelector("button[name*='ebsu']")).click();
		Thread.sleep(2000);
		driver.close();
		

	}

}
