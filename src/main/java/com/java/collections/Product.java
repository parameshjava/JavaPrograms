package com.java.collections;

public class Product {
	
	int id;
	String name;
	double price;
	
	public Product(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = prime + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}
	
	
	
}
