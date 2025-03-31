import java.util.ArrayList;
import java.util.Scanner;

class Stock {
    String stockName;
    int quantity;
    double price;

    public Stock(String stockName, int quantity, double price) {
        this.stockName = stockName;
        this.quantity = quantity;
        this.price = price;
    }

    public void buyStock(int qty) {
        this.quantity += qty;
        System.out.println(qty + " shares of " + stockName + " bought successfully.");
    }

    public void sellStock(int qty) {
        if (qty <= this.quantity) {
            this.quantity -= qty;
            System.out.println(qty + " shares of " + stockName + " sold successfully.");
        } else {
            System.out.println("Insufficient shares to sell.");
        }
    }

    public void displayStock() {
        System.out.println("Stock: " + stockName + ", Quantity: " + quantity + ", Price: " + price);
    }
}

public class StockTradingPlateform {
    static ArrayList<Stock> stocks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize stocks
        stocks.add(new Stock("AAPL", 10, 150.50));
        stocks.add(new Stock("GOOGL", 5, 2800.75));
        stocks.add(new Stock("TSLA", 8, 700.25));

        while (true) {
            System.out.println("\nStock Trading Platform");
            System.out.println("1. View Stocks");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewStocks();
                    break;
                case 2:
                    System.out.print("Enter stock name to buy: ");
                    scanner.nextLine(); // Consume newline
                    String buyStock = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int buyQty = scanner.nextInt();
                    buyStock(buyStock, buyQty);
                    break;
                case 3:
                    System.out.print("Enter stock name to sell: ");
                    scanner.nextLine(); // Consume newline
                    String sellStock = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int sellQty = scanner.nextInt();
                    sellStock(sellStock, sellQty);
                    break;
                case 4:
                    System.out.println("Exiting... Thank you for trading!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void viewStocks() {
        for (Stock stock : stocks) {
            stock.displayStock();
        }
    }

    public static void buyStock(String stockName, int qty) {
        for (Stock stock : stocks) {
            if (stock.stockName.equalsIgnoreCase(stockName)) {
                stock.buyStock(qty);
                return;
            }
        }
        System.out.println("Stock not found.");
    }

    public static void sellStock(String stockName, int qty) {
        for (Stock stock : stocks) {
            if (stock.stockName.equalsIgnoreCase(stockName)) {
                stock.sellStock(qty);
                return;
            }
        }
        System.out.println("Stock not found.");
    }
}
