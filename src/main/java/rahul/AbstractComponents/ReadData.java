package rahul.AbstractComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadData {

	public static String getData(String filename, String key) throws IOException {
		Properties properties = new Properties();

		FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "//src//main//resources//" + filename + ".properties");
		properties.load(fileInputStream);
		return properties.getProperty(key);
	}

}
