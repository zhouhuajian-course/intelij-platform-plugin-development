package test;

import javax.swing.*;
import java.awt.*;


public class TestAwtBorderLayout {
    public static void main(String[] args) {
        JFrame frame = new JFrame("测试窗口");
        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        panel.add(new Button("North"), BorderLayout.NORTH);
        panel.add(new Button("South"), BorderLayout.SOUTH);
        panel.add(new Button("East"), BorderLayout.EAST);
        panel.add(new Button("West"), BorderLayout.WEST);
        panel.add(new Button("Center"), BorderLayout.CENTER);

        frame.setContentPane(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

