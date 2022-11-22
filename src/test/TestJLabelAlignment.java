package test;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class TestJLabelAlignment {
    public static void main(String[] args) {
        JFrame frame = new JFrame("测试窗口");
        frame.setSize(400, 150);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // JPanel 默认流布局
        JPanel panel = new JPanel(new FlowLayout());

        Border border = BorderFactory.createLineBorder(Color.BLACK);

        JLabel label0 = new JLabel("默认");

        JLabel label1 = new JLabel("标签1");
        JLabel label2 = new JLabel("标签2");
        JLabel label3 = new JLabel("标签3");

        JLabel label4 = new JLabel("标签4");
        JLabel label5 = new JLabel("标签5");
        JLabel label6 = new JLabel("标签6");

        label1.setHorizontalAlignment(JLabel.LEFT);
        label2.setHorizontalAlignment(JLabel.CENTER);
        label3.setHorizontalAlignment(JLabel.RIGHT);
        label4.setVerticalAlignment(JLabel.TOP);
        label5.setVerticalAlignment(JLabel.CENTER);
        label6.setVerticalAlignment(JLabel.BOTTOM);

        label0.setBorder(border);
        label1.setBorder(border);
        label2.setBorder(border);
        label3.setBorder(border);
        label4.setBorder(border);
        label5.setBorder(border);
        label6.setBorder(border);

        label0.setPreferredSize(new Dimension(50, 50));
        label1.setPreferredSize(new Dimension(50, 50));
        label2.setPreferredSize(new Dimension(50, 50));
        label3.setPreferredSize(new Dimension(50, 50));
        label4.setPreferredSize(new Dimension(50, 50));
        label5.setPreferredSize(new Dimension(50, 50));
        label6.setPreferredSize(new Dimension(50, 50));
        
        panel.add(label0);
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        panel.add(label6);

        frame.setContentPane(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
