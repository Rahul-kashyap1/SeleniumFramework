package core;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v125.audits.model.BlockedByResponseIssueDetails;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Launch {

	@Test
	public void staticdropdown() {

//		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		Select s = new Select(driver.findElement(By.id("dropdown-class-example")));
		s.selectByVisibleText("Option1");

		driver.findElement(By.id("autocomplete")).sendKeys("India");

	}

	@Test(groups = {"Smoke"})
	public void dynamicDropdown() throws InterruptedException {

//		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("autocomplete")).sendKeys("Ind");
		Thread.sleep(2000);
		List<WebElement> elements = driver.findElements(By.xpath("//ul//li[@class='ui-menu-item']/div"));

		for (int i = 0; i < elements.size(); i++) {
			String option = elements.get(i).getText();
			if (option.equals("India")) {
				elements.get(i).click();
				break;
			}
		}

	}
}
