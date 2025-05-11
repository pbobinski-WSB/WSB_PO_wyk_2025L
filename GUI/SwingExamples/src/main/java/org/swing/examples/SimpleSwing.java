package org.swing.examples;

import javax.swing.*;

public class SimpleSwing {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Moje okno");
        JLabel label = new JLabel("Kliknij przycisk");
        JButton button = new JButton("Kliknij mnie");

        button.addActionListener(e -> label.setText("Witaj!"));

        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(button);

        frame.setContentPane(panel);
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}




