import java.io.IOException;
import java.util.Properties;

public class PropertiesService {

	public Properties getFiles() {

		Properties properties = new Properties();

		try {
			properties.load(Properties.class.getResourceAsStream("/test.properties"));
			return properties;

		} catch (IOException e) {
			e.printStackTrace();
			return null;

		}

	}

	public String getProperties(String name) {

		Properties properties = getFiles();

		String propertieValue = properties.get(name).toString();

		return propertieValue;
	}

}
