package com.escaperooms.spaceodyssey;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui {
    String code;
    public Gui(){
        this.lock();
    }
    public void lock(){
        //Creating the Frame
        JFrame frame = new JFrame("KeyPad");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);


        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter 4 Digit Code: ");
        JButton send = new JButton("Unlock");
        JTextArea outputs = new JTextArea(1,4);// accepts up to 10 characters
        send.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                code = outputs.getText();
                frame.dispose();
            }
        });
        // Text Area at the Center


        panel.add(label); // Components Added using Flow Layout
        panel.add(outputs);
        panel.add(send);

        outputs.setEditable(false);
        JPanel ta = new JPanel(); // the panel is not visible in output
        JButton[] numberButtons = new JButton[10];
        numberButtons[0] = new JButton(String.valueOf(0));
        numberButtons[0].setFont(new Font("Open Sans", 0, 14));
        numberButtons[0].setPreferredSize(new Dimension(150, 100));

        numberButtons[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                outputs.append(e.getActionCommand());

            }});
        ta.add(numberButtons[0]);
        for(int i = 1; i < numberButtons.length; i++ ) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Open Sans", 0, 14));
            numberButtons[i].setPreferredSize(new Dimension(150, 100));

            numberButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    outputs.append(e.getActionCommand());
                }});
            ta.add(numberButtons[i]);
        }
        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
        frame.toFront();
        frame.requestFocus();
    }
    public String getCode() {
        return code;
    }
}