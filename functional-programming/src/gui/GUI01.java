package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/******************************************************************************
 * This shows how an anonymous inner class can be used to respond to a button
 * press event. This used to be thought of a succinct way of achieving this
 * but the next version uses more compact syntax.
 * 
 * @author Dr Kevan Buckley, University of Wolverhampton, 2019
 ******************************************************************************/

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI01 {

    public static void main(String[] args) {
        JFrame f = new JFrame();
        JButton b = new JButton("Press Me");
        f.setLayout(new BorderLayout());
        f.add(b, BorderLayout.CENTER);

        b.addActionListener(event -> {
            String buttonLabel = event.getActionCommand();
            String uppercaseLabel = buttonLabel.toUpperCase();
            System.out.println("Button says: " + uppercaseLabel);
        });

        f.pack();
        f.setVisible(true);
    }
}


//public class GUI01 {
//
//  public static void main(String[] args) {
//    JFrame f = new JFrame();
//    JButton b = new JButton("Press Me");
//    f.setLayout(new BorderLayout());
//    f.add(b, BorderLayout.CENTER);
//    
//    b.addActionListener(new ActionListener() {
//      public void actionPerformed(ActionEvent event) {
//        System.out.println("Button says: " + 
//          event.getActionCommand());        
//      }
//    });
//        
//    f.pack();
//    f.setVisible(true);
//  }
//}
