package SeleniumReview;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import util.CommonMethods;

public class WindowHandlingReview extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
//		Ahead to http://uitestpractice.com/Students/Switchto
//			Get the parent title
//			Get the parentId
//			print the parent title and parentId
//			Click on the open in a new window
//			Get the child title
//			Get the childId
//			print the child title and childId
//			close the child window
	CommonMethods.setUpDriver("chrome", "http://uitestpractice.com/Students/Switchto");
	String parentTitle=driver.getTitle();
	String parentID=driver.getWindowHandle();
	System.out.println(parentID +" has the title: "+parentTitle);
	driver.findElement(By.xpath("//a[text()='Opens in a new window']"));
	Set<String> ids=driver.getWindowHandles();
	Thread.sleep(5000);
	Iterator<String> it=ids.iterator();
	Thread.sleep(5000);
	String childID="";
	while(it.hasNext()) {
		String ID=it.next();
		
		if(!parentID.equals(ID)) {
		    childID=ID;
		    }
		Thread.sleep(6000);
	}
	Thread.sleep(5000);
	driver.switchTo().window(childID);
	Thread.sleep(5000);
	String childTitle=driver.getTitle();
	Thread.sleep(2000);
	System.out.println(childID +" has the title: "+childTitle);
	Thread.sleep(2000);
	driver.close();
		
		

	}

}
