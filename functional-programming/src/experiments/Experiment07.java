package experiments;

import java.util.*;
import java.util.function.Consumer;

/******************************************************************************
 * This version is similar to the last but uses an anonymous inner class.
 * 
 * @author Dr Kevan Buckley, University of Wolverhampton, 2019
 ******************************************************************************/

import java.nio.file.*;
import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Experiment07 {

    public void run() {
        String csvFile = "products.csv";
        Path pathToFile = Paths.get(csvFile);

        try (Stream<String> lines = Files.lines(pathToFile)) {
            List<Product> products = lines
                    .skip(1) // Skip the header line
                    .map(Experiment07::lineToProduct) // Map each line to a Product object
                    .collect(Collectors.toList()); // Collect results to a List

            products.forEach(new Consumer<Product>() {
                public void accept(Product product) {
                    System.out.println(product);
                }
            });

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

    public static void main(String[] args) {
        new Experiment07().run();
    }
}


//public class Experiment07 {
//
// public void run() {
//    String[] n1 = { "Kevan", "John", "Matthew" };
//
//    List<String> n2 = Arrays.asList(n1);  
//
//    n2.forEach(new Consumer<String>() {
//      public void accept(String str) {
//        System.out.println(str);     
//      }
//    });
//  }
//
//  public static void main(String[] args) {
//    new Experiment07().run();
//  }
//}
