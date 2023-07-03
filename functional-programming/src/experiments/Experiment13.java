package experiments;

import java.util.function.Supplier;

/******************************************************************************
 * This version uses a Supplier to generate names;
 * 
 * @author Dr Kevan Buckley, University of Wolverhampton, 2019
 ******************************************************************************/

import java.nio.file.*;
import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Experiment13 {
    class ProductSupplier implements Supplier<Product> {
        List<Product> products;
        int nextIndex = 0;

        public ProductSupplier(String csvFile) {
            Path pathToFile = Paths.get(csvFile);
            try (Stream<String> lines = Files.lines(pathToFile)) {
                products = lines
                        .skip(1) // Skip the header line
                        .map(Experiment13::lineToProduct) // Map each line to a Product object
                        .collect(Collectors.toList()); // Collect results to a List
            } catch(IOException e) {
                e.printStackTrace();
            }
        }

        public Product get() {
            if(nextIndex < products.size()) {
                return products.get(nextIndex++);
            }
            return null;
        }
    }

    public void run() {
        ProductSupplier ps = new ProductSupplier("products.csv");

        System.out.println(ps.get());
        System.out.println(ps.get());
        System.out.println(ps.get());
        System.out.println(ps.get());
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
        new Experiment13().run();
    }
}


//public class Experiment13 {
//  class NameSupplier implements Supplier<String>{
//    String[] names = { "Kevan", "John", "Matthew" };
//    int nextIndex = 0;
//    public String get() {
//      if(nextIndex< names.length) {
//        return names[nextIndex++];
//      }
//      return null;
//    }  
//  }
//  
//  public void run() {
//    NameSupplier ns = new NameSupplier();
//
//    System.out.println(ns.get());
//    System.out.println(ns.get());
//    System.out.println(ns.get());
//    System.out.println(ns.get());
//  }
//
//  public static void main(String[] args) {
//    new Experiment13().run();
//  }
//}
