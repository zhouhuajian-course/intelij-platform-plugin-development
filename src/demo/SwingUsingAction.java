package demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingUsingAction {

    // 主窗口
    JFrame frame;

    // 动作类 动作对象
    class WebSearchAction extends AbstractAction {
        WebSearchAction(String name) {
            super(name);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand());
        }
    }

    // 搜索动作对象
    Action bingSearchAction = new WebSearchAction("必应搜索");
    Action baiduSearchAction = new WebSearchAction("百度搜索");
    Action sogouSearchAction = new WebSearchAction("搜狗搜索");

    void createAndShowGUI() {
        // 主窗口
        frame = new JFrame("SwingNotUsingAction");
        // 初始化菜单栏
        initMenuBar();
        // 初始化工具栏
        initToolBar();
        // 初始化编辑器
        initEditor();
        // 初始化控制台
        initConsole();
        frame.pack();
        frame.setVisible(true);
    }

    // 初始化菜单栏
    private void initMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("菜单");

        JMenu webSearchSubMenu = new JMenu("网页搜索(MenuBar)");
//        JMenuItem bingSearchMenuItem = new JMenuItem("必应搜索");
//        JMenuItem baiduSearchMenuItem = new JMenuItem("百度搜索");
//        JMenuItem sogouSearchMenuItem = new JMenuItem("搜狗搜索");
//        bingSearchMenuItem.addActionListener(webSearchActionListener);
//        baiduSearchMenuItem.addActionListener(webSearchActionListener);
//        sogouSearchMenuItem.addActionListener(webSearchActionListener);
//        webSearchSubMenu.add(bingSearchMenuItem);
//        webSearchSubMenu.add(baiduSearchMenuItem);
//        webSearchSubMenu.add(sogouSearchMenuItem);
        webSearchSubMenu.add(bingSearchAction);
        webSearchSubMenu.add(baiduSearchAction);
        webSearchSubMenu.add(sogouSearchAction);

        menu.add(webSearchSubMenu);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
    }

    // 初始化工具栏
    private void initToolBar() {
        JToolBar toolBar = new JToolBar();
//        JButton bingSearchButton = new JButton("必应搜索");
//        JButton baiduSearchButton = new JButton("百度搜索");
//        JButton sogouSearchButton = new JButton("搜狗搜索");
//        bingSearchButton.addActionListener(webSearchActionListener);
//        baiduSearchButton.addActionListener(webSearchActionListener);
//        sogouSearchButton.addActionListener(webSearchActionListener);
//        toolBar.add(bingSearchButton);
//        toolBar.add(baiduSearchButton);
//        toolBar.add(sogouSearchButton);
        toolBar.add(bingSearchAction);
        toolBar.add(baiduSearchAction);
        toolBar.add(sogouSearchAction);
        frame.add(toolBar, BorderLayout.NORTH);
    }

    // 初始化编辑器
    private void initEditor() {
        JTextArea editorTextArea = new JTextArea(20, 50);
        editorTextArea.append("假设这是编辑器");
        JPopupMenu editorPopupMenu = new JPopupMenu();
        JMenu webSearchSubMenu = new JMenu("网页搜索(Editor)");
//        JMenuItem bingSearchMenuItem = new JMenuItem("必应搜索");
//        JMenuItem baiduSearchMenuItem = new JMenuItem("百度搜索");
//        JMenuItem sogouSearchMenuItem = new JMenuItem("搜狗搜索");
//        bingSearchMenuItem.addActionListener(webSearchActionListener);
//        baiduSearchMenuItem.addActionListener(webSearchActionListener);
//        sogouSearchMenuItem.addActionListener(webSearchActionListener);
//        webSearchSubMenu.add(bingSearchMenuItem);
//        webSearchSubMenu.add(baiduSearchMenuItem);
//        webSearchSubMenu.add(sogouSearchMenuItem);
        webSearchSubMenu.add(bingSearchAction);
        webSearchSubMenu.add(baiduSearchAction);
        webSearchSubMenu.add(sogouSearchAction);
        editorPopupMenu.add(webSearchSubMenu);
        editorTextArea.setComponentPopupMenu(editorPopupMenu);
        frame.add(editorTextArea, BorderLayout.CENTER);
    }

    // 初始化控制台
    private void initConsole() {
        JTextArea consoleTextArea = new JTextArea(5, 50);
        consoleTextArea.setEditable(false);
        consoleTextArea.setBackground(new Color(220, 220, 220));
        consoleTextArea.append("假设这是控制台");
        JPopupMenu consolePopupMenu = new JPopupMenu();
        JMenu webSearchSubMenu = new JMenu("网页搜索(Console)");

//        JMenuItem bingSearchMenuItem = new JMenuItem("必应搜索");
//        JMenuItem baiduSearchMenuItem = new JMenuItem("百度搜索");
//        JMenuItem sogouSearchMenuItem = new JMenuItem("搜狗搜索");
//        bingSearchMenuItem.addActionListener(webSearchActionListener);
//        baiduSearchMenuItem.addActionListener(webSearchActionListener);
//        sogouSearchMenuItem.addActionListener(webSearchActionListener);
//        webSearchSubMenu.add(bingSearchMenuItem);
//        webSearchSubMenu.add(baiduSearchMenuItem);
//        webSearchSubMenu.add(sogouSearchMenuItem);
        webSearchSubMenu.add(bingSearchAction);
        webSearchSubMenu.add(baiduSearchAction);
        webSearchSubMenu.add(sogouSearchAction);

        consolePopupMenu.add(webSearchSubMenu);
        consoleTextArea.setComponentPopupMenu(consolePopupMenu);
        frame.add(consoleTextArea, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingUsingAction().createAndShowGUI();
            }
        });
    }
}









/*
    class WebSearchAction extends AbstractAction {
        WebSearchAction(String name) {
            super(name);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand());
        }
    }

    // 搜索动作对象
    Action bingSearchAction = new WebSearchAction("必应搜索");
    Action baiduSearchAction = new WebSearchAction("百度搜索");
    Action sogouSearchAction = new WebSearchAction("搜狗搜索");
 */




















/*
https://docs.oracle.com/javase/tutorial/uiswing/components/toplevel.html
Each GUI component can be contained only once. If a component is already in a container and you try to add it to another container, the component will be removed from the first container and then added to the second.

 */

