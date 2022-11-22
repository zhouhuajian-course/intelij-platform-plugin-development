package dictionary;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;

public class TranslateAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {

        // System.out.println("just a test");
        // 获取用户在编辑器选中的文本
        Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        SelectionModel selectionModel = editor.getSelectionModel();
        String selectedText = selectionModel.getSelectedText();
        // System.out.println(selectedText);

    }

}
