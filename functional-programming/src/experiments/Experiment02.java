package experiments;

/******************************************************************************
 * This program uses a foreach loop which is less error prone as it eliminates
 * the need for a loop control variable. 
 *  
 * @author Dr Kevan Buckley, University of Wolverhampton, 2019
 ******************************************************************************/

import java.nio.file.*;
import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Experiment02 {
    public static void main(String[] args) {
        try {
            Stream<String> lines = Files.lines(Paths.get("products.csv"));
            List<Product> products = lines.skip(1) // Skip header line
                                        .map(Experiment02::lineToProduct) // Map each line to a Product object
                                        .collect(Collectors.toList()); // Collect results to a List
            products.forEach(System.out::println);
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


//public class Experiment02 {
//  public static void main(String[] args) {
//    String[] n1 = { "Kevan", "John", "Matthew" };
//
//    for (String name : n1) {
//      System.out.println(name);
//    }
//  }
//}
