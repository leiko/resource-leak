package com.leiko.reproducer.resourceleak;

import java.util.LinkedList;
import java.util.Properties;
import java.util.Scanner;

public class Main {

	private static final Scanner SCANNER = new java.util.Scanner(System.in);

	private static String propFile = "/test.properties";

	public static void main(String[] args) throws InterruptedException {

		PropertiesService service;
		LinkedList<Properties> list = new LinkedList<>();

		System.out.println("Select: (1) resource leak | (2) fix");
		
		int option = SCANNER.nextInt();

		System.out.println("Execute \"lsof | grep " + propFile + " | wc -l\" to verify");
		
		switch (option) {
		case 1:
			service = new PropertiesServiceWithLeak(propFile);

			break;

		default:
			service = new PropertiesServiceFixed(propFile);

			break;
		}

		while (true) {						
									
			list.add(service.getProperties());
			
			Thread.sleep(1000);

		}

	}

}
