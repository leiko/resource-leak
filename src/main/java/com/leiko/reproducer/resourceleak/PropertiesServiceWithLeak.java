package com.leiko.reproducer.resourceleak;

import java.io.IOException;
import java.util.Properties;

public class PropertiesServiceWithLeak implements PropertiesService {

	@Override
	public String getProperty(String propertiesFile, String value) {

		Properties properties = new Properties();

		try {
			properties.load(Properties.class.getResourceAsStream(propertiesFile));

		} catch (IOException e) {
			e.printStackTrace();

		}

		return properties.get(value).toString();

	}


}
