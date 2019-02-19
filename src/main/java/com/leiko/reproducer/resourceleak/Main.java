package com.leiko.reproducer.resourceleak;

import java.util.Scanner;

public class Main {

	private static final Scanner SCANNER = new java.util.Scanner(System.in);

	static PropertiesService serviceWithLeak = new PropertiesServiceWithLeak();
	static PropertiesService serviceFixed = new PropertiesServiceFixed();

	public static void main(String[] args) throws InterruptedException {
		
		String propFile = "/test.properties";		

		System.out.println("Execute \"lsof | grep " + propFile + "\"");
		System.out.println("Select: (1) resource leak | (2) fix");
		int option = SCANNER.nextInt();

		switch (option) {
		case 1:
			readProperties(serviceWithLeak, propFile);
			break;

		default:
			readProperties(serviceFixed, propFile);
			break;
		}

	}

	static public void readProperties(PropertiesService service, String propFile) throws InterruptedException {

		for (int i = 0; i < 100; i++) {

			System.out.println(i + " " + service.getProperty(propFile, "prop1") + " "
					+ service.getProperty(propFile, "prop2") + " "
					+ service.getProperty(propFile, "prop3"));

			Thread.sleep(500);

		}

	}

}
