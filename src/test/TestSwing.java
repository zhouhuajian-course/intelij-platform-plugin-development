package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TestSwing {
    JFrame f = new JFrame("测试窗口");

    {
        changeLookAndFeel("Windows 风格");
    }

    JScrollPane sp = new JScrollPane();
    JTextArea textArea = new JTextArea();
    JButton b = new JButton("提交");
    JPopupMenu popupMenu = new JPopupMenu();
    public static void main(String[] args) {
        new TestSwing().start();
    }

    class LookAndFeelAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            changeLookAndFeel(e.getActionCommand());
        }
    }

    void start() {
        sp.setViewportView(textArea);
        f.add(sp, BorderLayout.CENTER);
        f.add(b, BorderLayout.SOUTH);

        JMenuItem menuItem1 = new JMenuItem("Metal 风格");
        JMenuItem menuItem2 = new JMenuItem("Windows 风格");
        JMenuItem menuItem3 = new JMenuItem("Windows Classic 风格");
        JMenuItem menuItem4 = new JMenuItem("Motif 风格");
        JMenuItem menuItem5 = new JMenuItem("Nimbus 风格");

        ActionListener actionListener = new LookAndFeelAction();
        menuItem1.addActionListener(actionListener);
        menuItem2.addActionListener(actionListener);
        menuItem3.addActionListener(actionListener);
        menuItem4.addActionListener(actionListener);
        menuItem5.addActionListener(actionListener);

        popupMenu.add(menuItem1);
        popupMenu.add(menuItem2);
        popupMenu.add(menuItem3);
        popupMenu.add(menuItem4);
        popupMenu.add(menuItem5);

        textArea.setComponentPopupMenu(popupMenu);

        f.setSize(500, 200);
        f.setVisible(true);
    }

    void changeLookAndFeel(String theme) {
        String lookAndFeel = "";
        switch (theme) {
            case "Metal 风格":
                lookAndFeel = "javax.swing.plaf.metal.MetalLookAndFeel";
                break;
            case "Windows 风格":
                lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
                break;
            case "Windows Classic 风格":
                lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel";
                break;
            case "Motif 风格":
                lookAndFeel = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
                break;
            case "Nimbus 风格":
                lookAndFeel = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
                break;

        }
        if (!lookAndFeel.isEmpty()) {
            try {
                UIManager.setLookAndFeel(lookAndFeel);
                SwingUtilities.updateComponentTreeUI(f);
            } catch (Exception e) {
            }
        }

    }
}






/*
// Metal风格 (默认)
String lookAndFeel = "javax.swing.plaf.metal.MetalLookAndFeel";
UIManager.setLookAndFee(lookAndFeel);

// Windows风格
String lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
UIManager.setLookAndFee(lookAndFeel);

// Windows Classic风格
String lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel";
UIManager.setLookAndFee(lookAndFeel);

// Motif风格
String lookAndFeel = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
UIManager.setLookAndFeel(lookAndFeel);

// Mac风格 (需要在相关的操作系统上方可实现)
String lookAndFeel = "com.sun.java.swing.plaf.mac.MacLookAndFeel";
UIManager.setLookAndFeel(lookAndFeel);

// GTK风格 (需要在相关的操作系统上方可实现)
String lookAndFeel = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
UIManager.setLookAndFeel(lookAndFeel);

// 可跨平台的默认风格
String lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
UIManager.setLookAndFeel(lookAndFeel);
// 当前系统的风格
String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
UIManager.setLookAndFeel(lookAndFeel);
     */