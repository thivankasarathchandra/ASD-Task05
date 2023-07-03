package experiments;

import java.util.*;

/******************************************************************************
 * In this code the array is converted to a List so that advantages of the 
 * Collections API my used later.
 * 
 * @author Dr Kevan Buckley, University of Wolverhampton, 2019
 ******************************************************************************/

import java.nio.file.*;
import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Experiment03 {
    public static void main(String[] args) {
        String csvFile = "products.csv";
        Path pathToFile = Paths.get(csvFile);

        try (Stream<String> lines = Files.lines(pathToFile)) {
            List<Product> products = lines
                    .skip(1) // Skip the header line
                    .map(Experiment03::lineToProduct) // Map each line to a Product object
                    .collect(Collectors.toList()); // Collect results to a List
            
            System.out.println(products.getClass());

            for(Product product : products) {
                System.out.println(product);
            }
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



//public class Experiment03 {
//  public static void main(String[] args) {
//    String[] n1 = { "Kevan", "John", "Matthew" };
//
//    List<String> n2 = Arrays.asList(n1);  
//    System.out.println(n2.getClass());
//
//    
//    for(String name:n2) {
//      System.out.println(name);
//    }
//  }
//}
