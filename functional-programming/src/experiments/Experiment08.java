package experiments;

import java.util.*;

/******************************************************************************
 * This version uses a stream then a parallel stream to process the data. Note
 * that in the first version the names are printed in the order that they are 
 * stored in the list. In the second version the data is processed concurrently
 * so the order the names are printed cannot be determined. This demonstrates
 * that if we have a problem in which the order of the data is processed does
 * not matter then parallelism can be taken advantage of.
 * 
 * @author Dr Kevan Buckley, University of Wolverhampton, 2019
 ******************************************************************************/

import java.nio.file.*;
import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Experiment08 {

    public void run() {
        String csvFile = "products.csv";
        Path pathToFile = Paths.get(csvFile);

        try (Stream<String> lines = Files.lines(pathToFile)) {
            List<Product> products = lines
                    .skip(1) // Skip the header line
                    .map(Experiment08::lineToProduct) // Map each line to a Product object
                    .collect(Collectors.toList()); // Collect results to a List

            System.out.println("Serial products\n---------");
            products.stream().forEach(product -> System.out.println(product));

            System.out.println("\nParallel products\n---------");
            products.parallelStream().forEach(product -> System.out.println(product));

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
        new Experiment08().run();
    }
}


//public class Experiment08 {
//
// public void run() {
//    String[] n1 = { "Kevan", "John", "Matthew" };
//
//    List<String> n2 = Arrays.asList(n1);  
//
//    System.out.println("Serial names\n---------");
//    n2.stream().forEach(name -> System.out.println(name));
//
//    System.out.println("\nParallel names\n---------");
//    n2.parallelStream().forEach(name -> System.out.println(name));
//  }
//
//  public static void main(String[] args) {
//    new Experiment08().run();
//  }
//}
