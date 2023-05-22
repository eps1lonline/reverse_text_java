package com.company;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame {
    private int w = 750;
    private int h = 500;
    private int sizeText = 40;
    private boolean writeText = false;
    private Font font = new Font("Arial", Font.BOLD, sizeText);

    public MainFrame() throws InterruptedException {
        // frame *********************************************************
        JFrame jFrame = new JFrame("Text formatting");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setBounds(0, 0, w, h);
        jFrame.setVisible(true);

        // name **********************************************************
        JLabel lName = new JLabel("Enter your text in this window:");
        lName.setFont(font);
        lName.setForeground(Color.black);
        lName.setBounds(80, 110, w, 50);

        // text field ****************************************************
        JTextField tName = new JTextField();
        tName.setFont(font);
        tName.setBackground(Color.WHITE);
        tName.setForeground(Color.BLACK);
        tName.setBounds(20, h/2 - 50, w-60, 80);

        // button ********************************************************
        JButton bInput = new JButton("Input");
        bInput.setFont(font);
        bInput.setBackground(Color.WHITE);
        bInput.setForeground(Color.BLACK);
        bInput.setBounds(w/2 - 160, h-180, 300, 100);

        Container cont = jFrame.getContentPane();
        cont.setBackground(Color.GRAY);
        cont.setLayout(null);

        cont.add(lName);
        cont.add(tName);
        cont.add(bInput);

        bInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tName.getText().length() == 0 || tName.getForeground() == Color.red) {
                    tName.setText("Enter text");
                    tName.setForeground(Color.red);
                    bInput.setForeground(Color.red);
                }

                if (tName.getText().length() != 0 && tName.getForeground() != Color.red) {
                    writeText = true;
                    jFrame.setVisible(false);

                    JFrame secondFrame = new JFrame("Text formatting");
                    secondFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    secondFrame.setBounds(0, 0, w, h);
                    secondFrame.setVisible(true);

                    secondFrame.add(new Paint(tName.getText()));
                }
            }
        });

        while (!writeText) {
            Thread.sleep(1);
            if (tName.getForeground() == Color.red) {
                Thread.sleep(1000);

                tName.setText("");
                tName.setForeground(Color.black);
                bInput.setForeground(Color.black);
            }
        }
    }
}
