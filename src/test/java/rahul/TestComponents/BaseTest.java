package rahul.TestComponents;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahul.AbstractComponents.ReadData;
import rahul.pageobjects.LoginPage;
import rahul.pageobjects.ProductsPage;

public class BaseTest {

	WebDriver driver;
	public LoginPage loginPage;
	public ProductsPage productsPage;

	public void initialization() throws IOException {

//		Properties properties = new Properties();
//
//		FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "//src//main//resources//config.properties");
//		properties.load(fileInputStream);

		String browserName = ReadData.getData("config", "browser");
//		String browser = properties.getProperty("browser");
//		String browser = System.getProperty("browser") != null ? System.getProperty("browser") : properties.getProperty("browser");
		String browser = System.getProperty("browser") != null ? System.getProperty("browser") : browserName;

		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		default:
			break;
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";

	}

	@BeforeMethod(alwaysRun = true)
	public LoginPage launchApplication() throws IOException {
		initialization();
		loginPage = new LoginPage(driver);
		loginPage.goTo();
		return loginPage;

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
}
