import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    private Map<String, Integer> stocks;
    private double cash;

    public Portfolio(double initialCash) {
        stocks = new HashMap<>();
        cash = initialCash;
    }

    public void buyStock(String symbol, int quantity, double price) {
        double cost = quantity * price;
        if (cash >= cost) {
            stocks.put(symbol, stocks.getOrDefault(symbol, 0) + quantity);
            cash -= cost;
            System.out.println("Bought " + quantity + " shares of " + symbol);
        } else {
            System.out.println("Not enough cash to buy " + quantity + " shares of " + symbol);
        }
    }

    public void sellStock(String symbol, int quantity, double price) {
        if (stocks.getOrDefault(symbol, 0) >= quantity) {
            stocks.put(symbol, stocks.get(symbol) - quantity);
            cash += quantity * price;
            System.out.println("Sold " + quantity + " shares of " + symbol);
        } else {
            System.out.println("Not enough shares to sell " + quantity + " of " + symbol);
        }
    }

    public double getPortfolioValue(MarketData marketData) {
        double totalValue = cash;
        for (Map.Entry<String, Integer> entry : stocks.entrySet()) {
            totalValue += entry.getValue() * marketData.getPrice(entry.getKey());
        }
        return totalValue;
    }

    public void printPortfolio(MarketData marketData) {
        System.out.println("Portfolio:");
        for (Map.Entry<String, Integer> entry : stocks.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " shares");
        }
        System.out.println("Cash: $" + cash);
        System.out.println("Total Portfolio Value: $" + getPortfolioValue(marketData));
    }
}
