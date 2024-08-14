package rahul.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahul.AbstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents {

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement selectCountryInput;

	@FindBy(xpath = "//span[@class='ng-star-inserted']")
	List<WebElement> countryList;
	@FindBy(xpath = "//a[text()='Place Order ']")
	WebElement placeOrderButton;

	public void selectCounty(String countryName) {
		sendKeys(selectCountryInput, countryName);
		waitForElementToAppear(countryList.get(0));
		selectValueFromDropdown(countryList, countryName);
	}

	public ConfirmationPage clickOnPlaceOrderButton() throws InterruptedException {
		click(placeOrderButton);
		return new ConfirmationPage(driver);
	}

}
