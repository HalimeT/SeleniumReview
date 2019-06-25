package SeleniumReview;

import util.CommonMethods;

public class iFrameHandling extends CommonMethods {
	public static void main(String[] args) {
		// TC 1: ToolsQA Frame verification
//		Open chrome browser
//		Go to “https://www.toolsqa.com/iframe-practice-page/”
//		Click on “Blogs” link inside first frame
//		Verify element “Interactions” is present in second frame.
//		Navigate to Home Page
//		Quit browser
		CommonMethods.setUpDriver("chrome", "https://www.toolsqa.com/iframe-practice-page/");
		driver.switchTo().frame("iframe1");
		
		
	}

}
