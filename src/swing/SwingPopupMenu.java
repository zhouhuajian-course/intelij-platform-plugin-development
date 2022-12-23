package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SwingPopupMenu {
    void createAndShowGUI() {
        JFrame frame = new JFrame();

        ActionListener webSearchActionListener = (e) -> {
            System.out.println(e.getActionCommand());
        };

        // 菜单栏
        JMenuBar menuBar = new JMenuBar();
        JMenu webSearchMenu = new JMenu("网页搜索");
        JMenuItem menuItem1 = new JMenuItem("必应搜索");
        JMenuItem menuItem2 = new JMenuItem("百度搜索");
        JMenuItem menuItem3 = new JMenuItem("搜狗搜索");
        menuItem1.addActionListener(webSearchActionListener);
        menuItem2.addActionListener(webSearchActionListener);
        menuItem3.addActionListener(webSearchActionListener);
        webSearchMenu.add(menuItem1);
        webSearchMenu.add(menuItem2);
        webSearchMenu.add(menuItem3);
        menuBar.add(webSearchMenu);

        // 工具栏
        JToolBar toolBar = new JToolBar();
        JButton button1 = new JButton("必应搜索");
        JButton button2 = new JButton("百度搜索");
        JButton button3 = new JButton("搜狗搜索");
        button1.addActionListener(webSearchActionListener);
        button2.addActionListener(webSearchActionListener);
        button3.addActionListener(webSearchActionListener);
        toolBar.add(button1);
        toolBar.add(button2);
        toolBar.add(button3);

        // 编辑器
        JTextArea editorTextArea = new JTextArea(20, 50);
        editorTextArea.append("假设这是编辑器");
        // 控制台
        JTextArea consoleTextArea = new JTextArea(5, 50);
        consoleTextArea.setEditable(false);
        consoleTextArea.setBackground(new Color(220, 220, 220));
        consoleTextArea.append("假设这是控制台");
        // 弹出式菜单
        JPopupMenu popupMenu = new JPopupMenu();
        JMenu webSearchMenu2 = new JMenu("网页搜索");
        webSearchMenu2.add(menuItem1);
        webSearchMenu2.add(menuItem2);
        webSearchMenu2.add(menuItem3);
        popupMenu.add(webSearchMenu2);
        // 编辑器、控制台设置弹出式菜单
        editorTextArea.setComponentPopupMenu(popupMenu);
        consoleTextArea.setComponentPopupMenu(popupMenu);
        frame.setJMenuBar(menuBar);
        frame.add(toolBar, BorderLayout.NORTH);
        frame.add(editorTextArea, BorderLayout.CENTER);
        frame.add(consoleTextArea, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SwingPopupMenu().createAndShowGUI();
        });
    }
}
