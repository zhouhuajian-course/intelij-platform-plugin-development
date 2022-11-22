package translate;

import com.intellij.openapi.wm.ToolWindow;
import com.intellij.util.io.URLUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class TranslateToolWindow {

    public TranslateToolWindow(ToolWindow toolWindow) {
    }

    public static JTextField textField = new JTextField();
    public static JButton button = new JButton("翻译");

    public JPanel getContent() {
        JPanel panel = new JPanel();
        JPanel formPanel = new JPanel();
        button = new JButton("翻译");
        JLabel label = new JLabel("");
        label.setHorizontalAlignment(JLabel.LEFT);
        label.setVerticalAlignment(JLabel.TOP);

        panel.setLayout(new BorderLayout());
        formPanel.setLayout(new BorderLayout());

        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        formPanel.add(textField, BorderLayout.CENTER);
        formPanel.add(button, BorderLayout.EAST);
        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(label, BorderLayout.CENTER);

        button.addActionListener(e -> {
            String words = textField.getText();
            String url = "https://cn.bing.com/dict/search?q=" + URLUtil.encodeURIComponent(words);
            String str = httpGet(url, "utf-8");
            int from = str.lastIndexOf("<div class=\"hd_area\">");
            int to = str.indexOf("</ul>", from) + "</ul>".length();
            System.out.println(str.substring(from, to));
            label.setText("<html>" + str.substring(from, to) + "</html>");
        });

        return panel;
    }

    public static String httpGet(String url, String charset) {
        StringBuilder sb = new StringBuilder();
        try {
            URLConnection conn = new URL(url).openConnection();
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36 Edg/107.0.1418.52");
            conn.connect();
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}
