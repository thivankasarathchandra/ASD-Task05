package experiments;

import java.util.*;

/******************************************************************************
 * This version moves from imperative style to declarative style programming.
 * The explicit loop is removed and a lamba expression is used to implement 
 * what was previously the body of a loop. A lamba expression is function
 * that can be passed as a parameter and does not have a name. Here the lambda
 * implements the Consumer interface, which takes a single parameter and 
 * produces no return value. 
 * 
 * @author Dr Kevan Buckley, University of Wolverhampton, 2019
 ******************************************************************************/

import java.nio.file.*;
import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Experiment05 {
    public static void main(String[] args) {
        String csvFile = "products.csv";
        Path pathToFile = Paths.get(csvFile);

        try (Stream<String> lines = Files.lines(pathToFile)) {
            List<Product> products = lines
                    .skip(1) 
                    .map(Experiment05::lineToProduct) // Map each line to a Product object
                    .collect(Collectors.toList()); // Collect results to a List

            products.forEach(product -> System.out.println(product));

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


//public class Experiment05 {
//  public static void main(String[] args) {
//    String[] n1 = { "Kevan", "John", "Matthew" };
//
//    List<String> n2 = Arrays.asList(n1);  
//
//    n2.forEach(name -> System.out.println(name));
//  }
//}
