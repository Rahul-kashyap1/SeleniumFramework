package core;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AlertConcept extends BaseTest {

	@Parameters({ "url" })
	@Test
	public void alert(String urlname) {

		setup();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("alertbtn")))).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		System.out.println("urlname " + urlname);
	}

	@Test(groups = { "Smoke" })
	public void alert1() {
		System.out.println("alert 1");
	}
}
