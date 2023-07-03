package gui;

import java.awt.*;
import javax.swing.*;

/******************************************************************************
 * This shows how a lambda can be used to respond to a button press event. This
 * version uses more compact and cleaner than the previous version.
 * 
 * @author Dr Kevan Buckley, University of Wolverhampton, 2019
 ******************************************************************************/


import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;

public class GUI02 {

    public static void main(String[] args) {
        JFrame f = new JFrame();
        JButton b = new JButton("Press Me");
        f.setLayout(new BorderLayout());
        f.add(b, BorderLayout.CENTER);
        b.addActionListener(
            event -> {
                String buttonLabel = event.getActionCommand();
                String uppercaseLabel = buttonLabel.toUpperCase();
                System.out.println("Button says: " + uppercaseLabel);
            }
        );
        f.pack();
        f.setVisible(true);
    }
}

//public class GUI02 {
//
//  public static void main(String[] args) {
//    JFrame f = new JFrame();
//    JButton b = new JButton("Press Me");
//    f.setLayout(new BorderLayout());
//    f.add(b, BorderLayout.CENTER);
//    b.addActionListener(
//        event -> System.out.println("Button says: " + 
//                   event.getActionCommand()));
//    f.pack();
//    f.setVisible(true);
//  }
//
//}
