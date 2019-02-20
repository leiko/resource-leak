package com.leiko.reproducer.resourceleak;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesServiceFixed implements PropertiesService {

	private String propertiesFile;

	public PropertiesServiceFixed(String propertiesFile) {
		this.propertiesFile = propertiesFile;
	}

	@Override
	public Properties getProperties() {
		
		Properties properties = new Properties();

		try (InputStream stream = PropertiesService.class.getResourceAsStream(this.propertiesFile)) {

			properties.load(stream);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return properties;

	}

}
