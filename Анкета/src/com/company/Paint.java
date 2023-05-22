package com.company;

import java.awt.*;
import javax.swing.*;

public class Paint extends JPanel {
    private String str;
    private int x = 20;
    private int y = -20;
    private int sizeText = 40;
    private Font font = new Font("Arial", Font.BOLD, sizeText);

    public Paint(String str) {
        this.str = str;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.black);
        g2d.setFont(font);

        int counter = 50;

        for (int i = 0; i < 8; i ++) {
            g2d.drawLine(20, counter, 700, counter);
            counter += 50;
        }

        g2d.rotate(Math.toRadians(90.));

        for (int i = 0; i < str.length(); i++) {
            if (x <= 400) {
                g2d.drawString(String.valueOf(str.charAt(i)), x, y);
                y -= 40;
            }

            if (y <= -700 && x <= 400) {
                y = -20;
                x += 50;
            }
        }
    }
}
