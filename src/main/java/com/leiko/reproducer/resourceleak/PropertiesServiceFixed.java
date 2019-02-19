package com.leiko.reproducer.resourceleak;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesServiceFixed implements PropertiesService {

	@Override
	public String getProperty(String propertiesFile, String value) {
		Properties properties = new Properties();

		try (InputStream stream = PropertiesService.class.getResourceAsStream(propertiesFile)) {

			properties.load(stream);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return properties.get(value).toString();

	}


}
