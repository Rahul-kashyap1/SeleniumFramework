package rahul.AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahul.pageobjects.CartPage;
import rahul.pageobjects.OrderPage;

public class AbstractComponents {

	WebDriver driver;
	public WebDriverWait wait;

	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}

	// ________success message____________
	@FindBy(css = "[class*='flyInOut']")
	WebElement errorMessage;

	// Header link
	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement cartLink;

	@FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
	WebElement orderLink;

	public void click(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator))).click();
	}

	public void click(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	public void sendKeys(WebElement element, String value) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(value);
	}

	public void waitForElementToAppear(By findBy) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void waitForElementToAppear(WebElement findBy) {
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}

	public void waitForElementToDisappear(WebElement ele) throws InterruptedException {
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}

	public void selectValueFromDropdown(List<WebElement> list, String value) {

		for (int i = 0; i < list.size(); i++) {
			String actual = list.get(i).getText();
			if (actual.equals(value)) {
				list.get(i).click();
				break;
			}
		}
	}

	public String getMessage() {
		return wait.until(ExpectedConditions.visibilityOf(errorMessage)).getText();
	}

	// Header

	public CartPage clickCartHeaderLink() {
		click(cartLink);
		return new CartPage(driver);

	}

	public OrderPage clickOrderLink() {
		click(orderLink);
		return new OrderPage(driver);

	}
	// logical

	public boolean compareFromList(List<WebElement> list, String expectedValue) {
		return list.stream().anyMatch(actual -> actual.getText().equals(expectedValue));
	}

}
