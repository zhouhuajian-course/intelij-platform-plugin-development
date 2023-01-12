package online.dictionary;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class OnlineDictionaryPanel extends JPanel {

    static class WordStringBlankException extends RuntimeException {

    }

    OnlineDictionaryPanel() {

        // 表单面板 里面放输入框和按钮
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BorderLayout());
        JTextField wordTextField = new JTextField();
        JButton lookUpButton = new JButton("查询");
        formPanel.add(wordTextField, BorderLayout.CENTER);
        formPanel.add(lookUpButton, BorderLayout.EAST);

        // 查询结果
        JLabel resultLabel = new JLabel();
        // 不加这两行，会默认 水平居左 垂直居中  显示
        resultLabel.setHorizontalAlignment(JLabel.LEFT);
        resultLabel.setVerticalAlignment(JLabel.TOP);
        // 有边框会更好看
        resultLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 有边框会更好看
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout());
        add(formPanel, BorderLayout.NORTH);
        add(resultLabel, BorderLayout.CENTER);

        lookUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result;
                try {
                    String word = wordTextField.getText();
//                    if (word.isBlank()) {
//                        throw new WordStringBlankException();
//                    }
                    if (word.isEmpty()) {
                        throw new WordStringBlankException();
                    }
                    String url = "https://cn.bing.com/dict/search?q=" + word;
                    Document document = Jsoup.connect(url).get();
                    String part1 = document.select(".qdef .hd_area").first().toString();
                    String part2 = document.select(".qdef ul").first().toString();
                    result = part1 + part2;
                } catch (WordStringBlankException exception) {
                    result = "<font color=yellow>请输入要查询的单词。</font>";
                }
                catch (IOException exception) {
                    result = "<font color=red>网络异常，请稍后再试。</font>";
                }
                catch (NullPointerException exception) {
                    result = "<font color=red>数据有误，请输入正确的单词。</font>";
                }
                resultLabel.setText("<html>" + result + "</html>");
            }
        });

        wordTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    lookUpButton.doClick();
                }
            }
        });
    }
}
