package experiments;

import java.lang.reflect.Method;
import java.util.*;

/******************************************************************************
 * In this code the array is converted to a List and the methods available to 
 * are listed using reflection. Note this is an immutable list so methods
 * such as add, which are defined in the List interface are not available. To
 * proved this try adding a name to the list (uncomment the code below).
 * 
 * @author Dr Kevan Buckley, University of Wolverhampton, 2019
 ******************************************************************************/

import java.lang.reflect.Method;
import java.nio.file.*;
import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Experiment04 {
    public static void main(String[] args) {
        String csvFile = "products.csv";
        Path pathToFile = Paths.get(csvFile);

        try (Stream<String> lines = Files.lines(pathToFile)) {
            List<Product> products = lines
                    .skip(1) 
                    .map(Experiment04::lineToProduct) // Map each line to a Product object
                    .collect(Collectors.toList()); // Collect results to a List

            System.out.println(products.getClass());

            for (Method m : products.getClass().getDeclaredMethods()) {
                System.out.println(m.getName());
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

//public class Experiment04 {
//  public static void main(String[] args) {
//    String[] n1 = { "Kevan", "John", "Matthew" };
//
//    List<String> n2 = Arrays.asList(n1);  
//    System.out.println(n2.getClass());
//
//    for(Method m: n2.getClass().getDeclaredMethods()) {
//      System.out.println(m.getName());
//    }
////    n2.add("new name");
//  }
//}
