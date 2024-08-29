package com.mycompany.stocktradingplatform;

import java.util.HashMap;
import java.util.Map;


public class MarketService {

    private Map<String, Stock> stockMarket;

    public MarketService() {
        this.stockMarket = new HashMap<>();
        stockMarket.put("AAPL", new Stock("AAPL", "Apple Inc.", 190.0));
        stockMarket.put("SAMSUNG", new Stock("SAMSUNG", "Alphabet Inc.", 260.0));

    }

    public Stock getStock(String symbol) {
        return stockMarket.get(symbol);
    }

    public Map<String, Stock> getStockMarket() {
        return stockMarket;
    }

    public void processOrder(Order order, Portfolio portfolio) {
        Stock stock = order.getStock();
        int quantity = order.getQuantity();
        double cost = stock.getPrice() * quantity;

        System.out.println("Processing " + order.getType() + " order for " + quantity + " shares of " + stock.getSymbol());
        System.out.println("Stock price: " + stock.getPrice());
        System.out.println("Total cost: " + cost);
        System.out.println("Current balance: " + portfolio.getBalance());
        System.out.println("Current stock quantity in portfolio: " + portfolio.getStocks().getOrDefault(stock, 0));

        if (OrderType.BUY.equals(order.getType()) && portfolio.getBalance() >= cost) {
            portfolio.addStock(stock, quantity);
            portfolio.updateBalance(-cost);
            System.out.println("Buy order processed. New balance: " + portfolio.getBalance());
        } else if (OrderType.SELL.equals(order.getType()) && portfolio.getStocks().getOrDefault(stock, 0) >= quantity) {
            portfolio.removeStock(stock, quantity);
            portfolio.updateBalance(cost);
            System.out.println("Sell order processed. New balance: " + portfolio.getBalance());
        } else {
            System.out.println("Order cannot be processed.");
        }
    }
}
