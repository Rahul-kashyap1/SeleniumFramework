package rahul.pageobjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahul.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='cartSection']//h3")
	List<WebElement> productList;

	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement checkoutButton;
	
	public boolean verifyProduct(String productName) {
		
		waitForElementToAppear(productList.get(0));
		click(productList.get(0));
		return compareFromList(productList, productName);
	}
	
	public CheckoutPage clickOnCheckoutButton() throws InterruptedException
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutButton);
		Thread.sleep(2000);
		click(checkoutButton);
		return new CheckoutPage(driver);
	}
}
