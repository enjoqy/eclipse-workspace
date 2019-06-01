package com.trnin;

public class JAC extends Car {
	
	private final static String BRAND = "JAC";

	public JAC() {
		this.setBrand(BRAND);
	}


	public JAC(String type, double prive, String color, int loadNum) {
		super(BRAND, type, prive, color, loadNum);
	}
	
	
}
