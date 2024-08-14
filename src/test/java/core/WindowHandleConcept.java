package core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class WindowHandleConcept extends BaseTest {

	@Test
	public static void handleWindow() {

		setup();
		System.out.println(driver.getTitle());

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("opentab")))).click();

		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		Set<String> windows = driver.getWindowHandles();

//		Iterator<String> it = windows.iterator();
//		String parentWindow = it.next();
//		String childWindow = it.next();

		ArrayList<String> list=new ArrayList<String>(windows);
		driver.switchTo().window(list.get(1));
		System.out.println(driver.getTitle());
	}
}
