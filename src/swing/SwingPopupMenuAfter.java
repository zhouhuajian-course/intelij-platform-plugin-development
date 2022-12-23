package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingPopupMenuAfter {
    class WebSearchAction extends AbstractAction {
        WebSearchAction(String text) {
            putValue(NAME, text);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand());
        }
    }

    void createAndShowGUI() {
        JFrame frame = new JFrame();
        // 动作
        Action action1 = new WebSearchAction("必应搜索");
        Action action2 = new WebSearchAction("百度搜索");
        Action action3 = new WebSearchAction("搜狗搜索");
        // action1.setEnabled(false);

        // 菜单栏
        JMenuBar menuBar = new JMenuBar();
        JMenu webSearchMenu = new JMenu("网页搜索");
        webSearchMenu.add(action1);
        webSearchMenu.add(action2);
        webSearchMenu.add(action3);
        menuBar.add(webSearchMenu);

        // 工具栏
        JToolBar toolBar = new JToolBar();
        toolBar.add(action1);
        toolBar.add(action2);
        toolBar.add(action3);

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
        webSearchMenu2.add(action1);
        webSearchMenu2.add(action2);
        webSearchMenu2.add(action3);
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
            new SwingPopupMenuAfter().createAndShowGUI();
        });
    }
}
