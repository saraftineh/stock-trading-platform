package com.mycompany.stocktradingplatform;

import java.util.HashMap;
import java.util.Map;

public class Portfolio {

    private double balance;
    private Map<Stock, Integer> stocks;

    public Portfolio(double initialBalance) {
        this.balance = initialBalance;
        this.stocks = new HashMap<>();
    }

    public double getBalance() {
        return balance;
    }

    public void updateBalance(double amount) {
        balance += amount;
    }

    public void addStock(Stock stock, int quantity) {
        stocks.put(stock, stocks.getOrDefault(stock, 0) + quantity);
    }

    public void removeStock(Stock stock, int quantity) {
        int currentQuantity = stocks.getOrDefault(stock, 0);
        if (currentQuantity >= quantity) {
            if (currentQuantity == quantity) {
                stocks.remove(stock);
            } else {
                stocks.put(stock, currentQuantity - quantity);
            }
        }
    }

    public Map<Stock, Integer> getStocks() {
        return stocks;
    }
}
