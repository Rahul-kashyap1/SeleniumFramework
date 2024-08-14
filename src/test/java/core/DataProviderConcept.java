package core;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderConcept {

	@Test(dataProvider = "getData")
	public void dataProvider(String fname, String lname) {

		System.out.println("fname: " + fname + " lname: " + lname);

	}

	@DataProvider
	public Object[][] getData() {

		return new Object[][] { { "firstname", "lastname" }, { "rahul", "kashyap" } };
	}
}
