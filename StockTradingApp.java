import java.util.Scanner;

public class StockTradingApp {
    public static void main(String[] args) {
        MarketData marketData = new MarketData();
        Portfolio portfolio = new Portfolio(10000.0);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            marketData.updatePrices();
            marketData.printPrices();
            portfolio.printPortfolio(marketData);

            System.out.println("Enter a command (buy, sell, quit):");
            String command = scanner.nextLine();

            if (command.equalsIgnoreCase("quit")) {
                break;
            }

            System.out.println("Enter stock symbol:");
            String symbol = scanner.nextLine().toUpperCase();

            System.out.println("Enter quantity:");
            int quantity = Integer.parseInt(scanner.nextLine());

            double price = marketData.getPrice(symbol);

            switch (command.toLowerCase()) {
                case "buy":
                    portfolio.buyStock(symbol, quantity, price);
                    break;
                case "sell":
                    portfolio.sellStock(symbol, quantity, price);
                    break;
                default:
                    System.out.println("Unknown command");
            }
        }

        scanner.close();
    }
}
