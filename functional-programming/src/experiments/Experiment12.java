package experiments;

import java.util.*;
import java.util.function.Function;

/******************************************************************************
 * This version does the same as the last except it is more explicit about the
 * Function implementation.
 * 
 * @author Dr Kevan Buckley, University of Wolverhampton, 2019
 ******************************************************************************/

import java.nio.file.*;
import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Experiment12 {
    class NameERemover implements Function<Product, String> {
        public String apply(Product product) {
            return product.getProductName().replaceAll("e", "");
        }
    }

    public void run() {
        String csvFile = "products.csv";
        Path pathToFile = Paths.get(csvFile);

        try (Stream<String> lines = Files.lines(pathToFile)) {
            List<Product> products = lines
                    .skip(1) // Skip the header line
                    .map(Experiment12::lineToProduct) // Map each line to a Product object
                    .collect(Collectors.toList()); // Collect results to a List

            products.stream().map(new NameERemover())
                    .forEach(productName -> System.out.println(productName));

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
        new Experiment12().run();
    }
}


//public class Experiment12 {
//  class ERemover implements Function<String, String> {
//    public String apply(String name) {
//      return name.replaceAll("e", "");
//    }
//  }
//  
//  public void run() {
//    String[] n1 = { "Kevan", "John", "Matthew" };
//
//    List<String> n2 = Arrays.asList(n1);
//
//    n2.stream().map(new ERemover())
//        .forEach(name -> System.out.println(name));
//
//  }
//
//  public static void main(String[] args) {
//    new Experiment12().run();
//  }
//}
