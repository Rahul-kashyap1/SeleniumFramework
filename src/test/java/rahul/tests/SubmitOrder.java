package rahul.tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rahul.TestComponents.BaseTest;
import rahul.pageobjects.CartPage;
import rahul.pageobjects.CheckoutPage;
import rahul.pageobjects.ConfirmationPage;
import rahul.pageobjects.OrderPage;
import rahul.pageobjects.ProductsPage;

public class SubmitOrder extends BaseTest {

	String zaraCoat = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups = { "purchase" })
	public void submitOrder(String email, String password, String productName) throws InterruptedException, IOException {

		ProductsPage productsPage = loginPage.loginApplication(email, password);

		// click on add to cart
		productsPage.clickAddToCart(productName);
		CartPage cartPage = productsPage.clickCartHeaderLink();

		assertTrue(cartPage.verifyProduct(productName));
		CheckoutPage checkoutPage = cartPage.clickOnCheckoutButton();

		checkoutPage.selectCounty("India");
		ConfirmationPage confirmationPage = checkoutPage.clickOnPlaceOrderButton();
		assertTrue(confirmationPage.getMessage().equalsIgnoreCase("Thankyou for the order."));
	}

//	@Test(dataProvider = "getData", groups = { "purchase" })
//	public void submitOrder(HashMap<String, String> input) throws InterruptedException, IOException {
//
//		ProductsPage productsPage = loginPage.loginApplication(input.get("email"), input.get("password"));
//
//		// click on add to cart
//		productsPage.clickAddToCart(input.get("product"));
//		CartPage cartPage = productsPage.clickCartHeaderLink();
//
//		assertTrue(cartPage.verifyProduct(input.get("product")));
//		CheckoutPage checkoutPage = cartPage.clickOnCheckoutButton();
//
//		checkoutPage.selectCounty("India");
//		ConfirmationPage confirmationPage = checkoutPage.clickOnPlaceOrderButton();
//		assertTrue(confirmationPage.getMessage().equalsIgnoreCase("Thankyou for the order."));
//	}

	@Test(dependsOnMethods = { "submitOrder" })
	public void orderHistory() {
		ProductsPage productsPage = loginPage.loginApplication("kashyap@gmail.com", "Rahul@123");
		OrderPage orderPage = productsPage.clickOrderLink();
		assertTrue(orderPage.verifyOrder(zaraCoat));

	}

	@DataProvider
	public Object[][] getData() {
		return new Object[][] { { "kashyap@gmail.com", "Rahul@123", "ZARA COAT 3" }, { "kashyap@gmail.com", "Rahul@123", "ADIDAS ORIGINAL" } };
	}

//	@DataProvider
//	public Object[][] getData() {
//
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email", "kashyap@gmail.com");
//		map.put("password", "Rahul@123");
//		map.put("product", "ZARA COAT 3");
//
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map.put("email", "kashyap@gmail.com");
//		map.put("password", "Rahul@123");
//		map.put("product", "ADIDAS ORIGINAL");
//		return new Object[][] { { map }, { map1 } };
//	}
}
