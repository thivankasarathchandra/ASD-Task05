package experiments;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/******************************************************************************
 * This program demonstrates the imperative way of storing some data and 
 * processing it.
 * 
 * @author Dr Kevan Buckley, University of Wolverhampton, 2019
 ******************************************************************************/

public class Experiment01 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("products.csv"))) {
            List<Product> products = br.lines()
                    .skip(1) 
                    .map(line -> {
                        String[] data = line.split(",");
                        int productID = Integer.parseInt(data[0]);
                        String productName = data[1];
                        String category = data[2];
                        double price = Double.parseDouble(data[3]);
                        int quantitySold = Integer.parseInt(data[4]);
                        return new Product(productID, productName, category, price, quantitySold);
                    })
                    .collect(Collectors.toList());
            products.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//public class Experiment01 {
//  public static void main(String[] args) {
//    String [] n1 = {"Kevan", "John", "Matthew"};
//
//    System.out.println(n1.getClass());
//    
//    for(int i=0;i<n1.length;i++) {
//      System.out.println(n1[i]);
//    }
//  }
//}
