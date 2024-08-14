package rahul.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import rahul.AbstractComponents.AbstractComponents;

public class ProductsPage extends AbstractComponents {

	WebDriver driver;

	public ProductsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	By productAddedMessage = By.xpath("//div[@aria-label='Product Added To Cart']");
	

	// Actions
	public void clickAddToCart(String productName) throws InterruptedException {
		click(By.xpath("//h5[normalize-space()='" + productName + "']/following-sibling::button[text()=' Add To Cart']"));
		waitForElementToAppear(productAddedMessage);
		waitForElementToDisappear(driver.findElement(productAddedMessage));
	}
}
