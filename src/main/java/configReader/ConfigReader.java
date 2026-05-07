package configReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public static String getProperty(String key) throws IOException {
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties");
		Properties pr=new Properties();
		pr.load(fis);
		String output=(String) pr.get(key);
		return output;
	}
}
