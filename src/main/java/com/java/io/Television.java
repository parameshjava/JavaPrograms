package com.java.io;

import java.io.Serializable;

public class Television implements Serializable, Cloneable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    int id;

    String model;

    double price;

    String dimensions;

    transient double tax;

    public Television(int id, String model, double price, String dimensions) {
        super();
        this.id = id;
        this.model = model;
        this.price = price;
        this.dimensions = dimensions;
        this.tax = (price * 5) / 100;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Television [id=").append(id).append(", model=").append(model).append(", price=").append(price)
                .append(", dimensions=").append(dimensions).append(", tax=").append(tax).append("]");
        return builder.toString();
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
