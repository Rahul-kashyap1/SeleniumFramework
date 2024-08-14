package core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class ScrollConcept extends BaseTest {

	@Test
	public static void scrolling() {
		
		setup();
		
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.id("mousehover")));
	}
	
	@Test
	public void scrolling1()
	{
		System.out.println("Scrolling");
	}
}
