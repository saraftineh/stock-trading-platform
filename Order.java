package com.mycompany.stocktradingplatform;

public class Order {

    private Stock stock;
    private int quantity;
    private String type;

    public Order(Stock stock, int quantity, String type) {
        this.stock = stock;
        this.quantity = quantity;
        this.type = type;
    }

    public Stock getStock() {
        return stock;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getType() {
        return type;
    }

}
