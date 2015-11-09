package com.java.collections;

public class ProductComparison {

	public static void main(String[] args) {
		Product p1 = new Product(1, "MotoX", 300.50);
		Product p2 = new Product(2, "MotoX", 300.50);
		boolean isSmae = p1.equals(p2);
		System.out.println("isSame : " + isSmae);
	}
}
