package translate;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowManager;
import translate.TranslateToolWindow;

import javax.swing.*;
import java.util.Arrays;

public class TranslateAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        String selectedText = e.getRequiredData(CommonDataKeys.EDITOR).getCaretModel().getCurrentCaret().getSelectedText();
        ToolWindow toolWindow = ToolWindowManager.getInstance(e.getProject()).getToolWindow("Translate");
        TranslateToolWindow.textField.setText(selectedText);
        TranslateToolWindow.button.doClick();
        // System.out.println(Arrays.toString(TranslateToolWindow.panel.getComponents()));
        toolWindow.show();
    }
}
