package rahul.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import rahul.TestComponents.BaseTest;

public class ErrorValidation extends BaseTest {

	@Test
	public void loginErrorValidation() {
		loginPage.loginApplication("kashyap@gmail.com", "Rahul@12");
		assertEquals("Incorrect email or password.", loginPage.getMessage());
	}
}
