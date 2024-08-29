package com.mycompany.stocktradingplatform;

import java.util.Scanner;


public class StockTradingPlatform {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MarketService marketService = new MarketService();
        Portfolio portfolio = new Portfolio(10000); // Initial balance

        // Application loop
        while (true) {
            System.out.println("Enter command (buy, sell, view, quit):");
            String command = scan.nextLine();

            if (command.equalsIgnoreCase("quit")) {
                break;
            } else if (command.equalsIgnoreCase("view")) {
                System.out.println("Balance: $" + portfolio.getBalance());
                System.out.println("Portfolio: " + portfolio.getStocks());
            } else if (command.equalsIgnoreCase("buy") || command.equalsIgnoreCase("sell")) {
                System.out.println("Enter stock symbol:");
                String symbol = scan.nextLine();
                System.out.println("Enter quantity:");
                int quantity = Integer.parseInt(scan.nextLine());

                Stock stock = marketService.getStock(symbol);
                if (stock == null) {
                    System.out.println("Stock not found.");
                    continue;
                }

                String type = command.equalsIgnoreCase("buy") ? OrderType.BUY : OrderType.SELL;
                Order order = new Order(stock, quantity, type);
                marketService.processOrder(order, portfolio);
            }
        }

        scan.close();
    }
}
