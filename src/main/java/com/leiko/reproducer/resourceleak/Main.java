package com.leiko.reproducer.resourceleak;

public class Main {

	static PropertiesService propService = new PropertiesService();
	
	public static void main(String[] args) throws InterruptedException {

		Thread.sleep(5000);

		for (int i = 0; i < 100; i++) {

			System.out.println("i: " + i + " " + propService.getProperties("prop2"));	
			
			Thread.sleep(500);

		}

	}

}
