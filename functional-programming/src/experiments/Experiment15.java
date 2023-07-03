package experiments;

import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

/******************************************************************************
 * Another example of implementing a functional interface. This is included
 * because it shows a function that returns a different type to its input.
 * 
 * @author Dr Kevan Buckley, University of Wolverhampton, 2019
 ******************************************************************************/
import java.nio.file.*;
import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Experiment15 {
    public static void main(String[] args) {
        ToDoubleFunction<Product> reciprocalQuantity = new ToDoubleFunction<Product>() {
            public double applyAsDouble(Product product) {
                return 1.0 / product.getQuantitySold();
            }
        };

        String csvFile = "products.csv";
        Path pathToFile = Paths.get(csvFile);

        try (Stream<String> lines = Files.lines(pathToFile)) {
            List<Product> products = lines
                    .skip(1) // Skip the header line
                    .map(Experiment15::lineToProduct) // Map each line to a Product object
                    .collect(Collectors.toList()); // Collect results to a List

            System.out.println(reciprocalQuantity.applyAsDouble(products.get(0))); // Apply to the first product

            products.stream().mapToDouble(reciprocalQuantity)
                .forEach(x -> System.out.println(x));

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

//public class Experiment15 {
//  public static void main(String[] args) {
//    Function<Integer, Double> reciprocal = new Function<Integer, Double>() {
//      public Double apply(Integer n) {
//        return 1.0 / n;
//      }
//    };
//    System.out.println(reciprocal.apply(10));
//
//    IntStream denominators = IntStream.range(1, 10);
//    denominators.map((IntUnaryOperator) reciprocal)
//        .forEach(x -> System.out.println(x));
//  }
//}
