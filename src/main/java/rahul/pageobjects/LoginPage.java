package rahul.pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahul.AbstractComponents.AbstractComponents;
import rahul.AbstractComponents.ReadData;

public class LoginPage extends AbstractComponents {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userEmail")
	WebElement userEmailInput;

	@FindBy(id = "userPassword")
	WebElement userPasswordInput;

	@FindBy(id = "login")
	WebElement loginButton;

	public ProductsPage loginApplication(String username, String password) {
		userEmailInput.sendKeys(username);
		userPasswordInput.sendKeys(password);
		loginButton.click();
		return new ProductsPage(driver);
	}

	public void goTo() throws IOException {
		String url = ReadData.getData("config", "url");
		String actualUrl = System.getProperty("url") != null ? System.getProperty("url") : url;
		driver.get(actualUrl);
	}

}
