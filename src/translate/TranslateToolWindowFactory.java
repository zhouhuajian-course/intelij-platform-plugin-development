package translate;


import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import com.intellij.ui.content.ContentManager;
import org.jetbrains.annotations.NotNull;
import translate.TranslateToolWindow;

public class TranslateToolWindowFactory implements ToolWindowFactory {

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        TranslateToolWindow translateToolWindow = new TranslateToolWindow(toolWindow);
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        Content content = contentFactory.createContent(translateToolWindow.getContent(), "", false);
        toolWindow.getContentManager().addContent(content);

//        ContentManager contentManager = toolWindow.getContentManager();
//        Content content = contentManager.getFactory().createContent(
//                translateToolWindow.getContent(), null, false);
//        contentManager.addContent(content);
    }

}

/*
Better Sample

===================================================

package online.dictionary;


import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import com.intellij.ui.content.ContentManager;
import org.jetbrains.annotations.NotNull;

public class OnlineDictionaryToolWindowFactory implements ToolWindowFactory {

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        // toolWindow是当前工具窗口对象
        ContentManager contentManager = toolWindow.getContentManager();
        // displayName是单个Tab标签的标题
        // displayName @Nullable
        Content content = contentManager.getFactory().createContent(
                new OnlineDictionaryPanel(), null, false);
        contentManager.addContent(content);

//        Content content2 = contentManager.getFactory().createContent(
//                new OnlineDictionaryPanel(), "456", false);
//        contentManager.addContent(content2);
    }

}

===================================================

package online.dictionary;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
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
                    if (word.isBlank()) {
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

 */