package experiments;

import java.time.LocalDate;
import java.util.function.Supplier;

/******************************************************************************
 * This is another example of using a supplier. Suppliers will be used like 
 * this in realtime applications for capturing things like sensor readings.
 * 
 * @author Dr Kevan Buckley, University of Wolverhampton, 2019
 ******************************************************************************/

import java.nio.file.*;
import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Experiment16 {
    public static void main(String[] args) {
        Supplier<Product> firstProductSupplier = new Supplier<Product>() {
            public Product get() {
                String csvFile = "products.csv";
                Path pathToFile = Paths.get(csvFile);

                try (Stream<String> lines = Files.lines(pathToFile)) {
                    return lines
                            .skip(1) // Skip the header line
                            .map(Experiment16::lineToProduct) // Map each line to a Product object
                            .findFirst().orElse(null); // Return the first product or null if the list is empty
                } catch(IOException e) {
                    e.printStackTrace();
                }

                return null;
            }
        };

        System.out.printf("The first product is %s", firstProductSupplier.get());
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


//public class Experiment16 {
//  public static void main(String[] args) {
//    Supplier<String> dateSupplier = new Supplier<String>() {
//      public String get() {
//        LocalDate date = LocalDate.now(); 
//        return date.toString();
//      }
//    };  
//    System.out.printf("Today is %s", dateSupplier.get());
//  }
//}
