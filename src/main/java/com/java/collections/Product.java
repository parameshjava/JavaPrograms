package com.java.collections;

import org.apache.commons.lang.StringUtils;

public class Product implements Comparable<Product> {

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
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        long temp;
        temp = Double.doubleToLongBits(price);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Product other = (Product) obj;

        if (!StringUtils.equals(name, other.name)) {
            return false;
        }
        if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Product [id=").append(id).append(", name=").append(name).append(", price=").append(price)
                .append("]");
        return builder.toString();
    }

    @Override
    public int compareTo(Product other) {
        int idCompare = Integer.compare(id, other.id);
        if (idCompare == 0) {
            int nameCompare = name.compareTo(other.name);
            if (nameCompare == 0) {
                return Double.compare(price, other.price);
            }
            return nameCompare;
        }
        return idCompare;
    }

}
