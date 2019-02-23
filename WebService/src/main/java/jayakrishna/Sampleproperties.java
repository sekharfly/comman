package jayakrishna;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

public class Sampleproperties {

	public void main1() {

		Properties prop = new Properties();
		InputStream input = null;
		try {

			String filename = "config.properties";
			input = this.getClass().getClassLoader().getResourceAsStream(filename);
			if (input == null) {
				System.out.println("Sorry, unable to find " + filename);
				return;
			}

			prop.load(input);

			Enumeration<?> e = prop.propertyNames();
			while (e.hasMoreElements()) {
				String key = (String) e.nextElement();
				String value = prop.getProperty(key);
				System.out.println("Key : " + key + ", Value : " + value);
			}

		} catch (IOException ex) {
			ex.printStackTrace();

		}

	}
	
}
