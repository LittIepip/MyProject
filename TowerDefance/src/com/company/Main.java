package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main extends Frame {

    private static int size = 0;

    public static void main(String[] args) {
        Main main = new Main();
        new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                size = (size + 1) % 250;
                main.revalidate();
                main.repaint();
            }
        }).start();
    }

    public Main() throws HeadlessException {
        super("Test");
        setSize(400, 300);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
        setLocation(400, 250);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.PINK);
        g.fillOval(100, 100, size, size);
    }
}
