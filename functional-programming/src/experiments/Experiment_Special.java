package experiments;

import java.nio.file.*;
import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Experiment_Special {
    public static void main(String[] args) {
        String csvFile = "products.csv";
        Path pathToFile = Paths.get(csvFile);

        try (Stream<String> lines = Files.lines(pathToFile)) {
            List<Product> products = lines
                    .skip(1) // Skip the header line
                    .map(Experiment_Special::lineToProduct) // Map each line to a Product object
                    .collect(Collectors.toList()); // Collect results to a List

            // Timer
            long start = System.currentTimeMillis();
            double totalSales1 = products.stream()
                    .mapToDouble(product -> product.getPrice() * product.getQuantitySold())
                    .sum();
            System.out.printf("Sequential processing took %d ms. Total sales: %.2f%n",
                    System.currentTimeMillis() - start, totalSales1);
            start = System.currentTimeMillis();
            double totalSales2 = products.parallelStream()
                    .mapToDouble(product -> product.getPrice() * product.getQuantitySold())
                    .sum();
            System.out.printf("Parallel processing took %d ms. Total sales: %.2f%n",
                    System.currentTimeMillis() - start, totalSales2);

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private static Product lineToProduct(String line) {
        String[] attributes = line.split(",");
        int productID = Integer.parseInt(attributes[0]);
        String productName = attributes[1];
        String category = attributes[2];
        double price = Double.parseDouble(attributes[3]);
        int quantitySold = Integer.parseInt(attributes[4]);

        return new Product(productID, productName, category, price, quantitySold);
    }
}
