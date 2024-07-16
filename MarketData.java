import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MarketData {
    private Map<String, Double> stockPrices;
    private Random random;

    public MarketData() {
        stockPrices = new HashMap<>();
        random = new Random();
        initializePrices();
    }

    private void initializePrices() {
        stockPrices.put("AAPL", 150.0);
        stockPrices.put("GOOG", 2800.0);
        stockPrices.put("AMZN", 3500.0);
        stockPrices.put("TSLA", 700.0);
    }

    public double getPrice(String symbol) {
        return stockPrices.get(symbol);
    }

    public void updatePrices() {
        for (String symbol : stockPrices.keySet()) {
            double oldPrice = stockPrices.get(symbol);
            double newPrice = oldPrice * (1 + (random.nextDouble() - 0.5) / 10);
            stockPrices.put(symbol, newPrice);
        }
    }

    public void printPrices() {
        System.out.println("Current Market Prices:");
        for (Map.Entry<String, Double> entry : stockPrices.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
