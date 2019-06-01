package com.trnin;

public class Enjoy extends Car {
	
	private final static String BRAND = "五菱" ;

	public Enjoy() {
		this.setBrand(BRAND);
	}

	public Enjoy(String brand, String type, double prive, String color, int loadNum) {
		super(BRAND, type, prive, color, loadNum);
	}

	
	

}
