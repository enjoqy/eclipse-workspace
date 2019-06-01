package com.trnin;

public class Car {
	
	private String brand;
	private String type;
	private double prive;
	private String color;
	private int loadNum;
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrive() {
		return prive;
	}
	public void setPrive(double prive) {
		this.prive = prive;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getLoadNum() {
		return loadNum;
	}
	public void setLoadNum(int loadNum) {
		this.loadNum = loadNum;
	}
	
	public Car() {
	}
	public Car(String brand, String type, double prive, String color, int loadNum) {
		this.brand = brand;
		this.type = type;
		this.prive = prive;
		this.color = color;
		this.loadNum = loadNum;
	}
	@Override
	public String toString() {
		return "Car [brand=" + brand + ", type=" + type + ", prive=" + prive + ", color=" + color + ", loadNum="
				+ loadNum + "]";
	}
	
	
	
}
