package experiments;

import java.util.*;

/******************************************************************************
 * This version introduces the use of a Function. A function takes a parameter
 * and returns a result. In this case all occurrences of the lowercase letter e 
 * are removed from the names. 
 * 
 * @author Dr Kevan Buckley, University of Wolverhampton, 2019
 ******************************************************************************/


import java.nio.file.*;
import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Experiment11 {

    public void run() {
        String csvFile = "products.csv";
        Path pathToFile = Paths.get(csvFile);

        try (Stream<String> lines = Files.lines(pathToFile)) {
            List<Product> products = lines
                    .skip(1) // Skip the header line
                    .map(Experiment11::lineToProduct) // Map each line to a Product object
                    .collect(Collectors.toList()); // Collect results to a List

            products.stream()
                    .map(product -> product.getProductName().replaceAll("e", ""))
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
        new Experiment11().run();
    }
}

//public class Experiment11 {
//
//  public void run() {
//    String[] n1 = { "Kevan", "John", "Matthew" };
//
//    List<String> n2 = Arrays.asList(n1);
//
//    n2.stream().map(name -> name.replaceAll("e", ""))
//        .forEach(name -> System.out.println(name));
//
//  }
//
//  public static void main(String[] args) {
//    new Experiment11().run();
//  }
//}
