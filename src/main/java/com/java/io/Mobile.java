package com.java.io;

import java.io.Serializable;

public class Mobile implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    int id;

    String maodel;

    double price;

    int ramSize;

    int romSize;

    public Mobile(int id, String maodel, double price, int ramSize, int romSize) {
        super();
        this.id = id;
        this.maodel = maodel;
        this.price = price;
        this.ramSize = ramSize;
        this.romSize = romSize;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Mobile [id=").append(id).append(", maodel=").append(maodel).append(", price=").append(price)
                .append(", ramSize=").append(ramSize).append(", romSize=").append(romSize).append("]");
        return builder.toString();
    }

}
