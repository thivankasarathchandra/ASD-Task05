package files;

import java.io.*;

/******************************************************************************
 * This program reads a text file and only prints the lines containing the word
 * "his".
 * 
 * @author Dr Kevan Buckley, University of Wolverhampton, 2019
 ******************************************************************************/

public class Files03 {

  public static void main(String[] args) throws Exception {
    BufferedReader r = new BufferedReader(new FileReader("data/wolf-fox.txt"));

    r.lines().filter(l -> l.contains("his"))
        .forEach(l -> System.out.println(l));

    r.close();
  }

}
