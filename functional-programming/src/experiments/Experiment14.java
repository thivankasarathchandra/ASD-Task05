package experiments;

import java.util.stream.Stream;

/******************************************************************************
 * This version uses a StreamBuilder to generate a Stream of Names.
 * 
 * @author Dr Kevan Buckley, University of Wolverhampton, 2019
 ******************************************************************************/


import java.nio.file.*;
import java.io.*;
import java.util.stream.*;

public class Experiment14 {
    class ProductStreamBuilder {
        String csvFile;

        public ProductStreamBuilder(String csvFile) {
            this.csvFile = csvFile;
        }

        public Stream<Product> build() {
            Stream.Builder<Product> builder = Stream.builder();
            Path pathToFile = Paths.get(csvFile);

            try (Stream<String> lines = Files.lines(pathToFile)) {
                lines
                    .skip(1) // Skip the header line
                    .map(Experiment14::lineToProduct) // Map each line to a Product object
                    .forEach(builder::add); // Add each product to the builder
            } catch(IOException e) {
                e.printStackTrace();
            }

            return builder.build();
        }
    }

    public void run() {
        ProductStreamBuilder builder = new ProductStreamBuilder("products.csv");
        Stream<Product> productStream = builder.build();
        productStream.forEach(product -> System.out.println(product));
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
        new Experiment14().run();
    }
}

//public class Experiment14 {
//  class NameStreamBuilder {
//    public Stream<String> build(){
//      Stream.Builder<String> builder = Stream.builder(); 
//      builder.add("Kevan");
//      builder.add("John");
//      builder.add("Matthew");
//      return builder.build();
//    }
//  }
//  
//  public void run() {
//    NameStreamBuilder builder = new NameStreamBuilder();
//    Stream <String> nameStream = builder.build();
//    nameStream.forEach(n -> System.out.println(n));
//  }
//
//  public static void main(String[] args) {
//    new Experiment14().run();
//  }
//}
