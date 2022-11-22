package translate;

import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.util.io.URLUtil;

public class WebTranslateAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        String selectedText = e.getRequiredData(CommonDataKeys.EDITOR).getCaretModel().getCurrentCaret().getSelectedText();
        // e.getRequiredData(CommonDataKeys.EDITOR).getSelectionModel().getSelectedText();
        String url = "https://cn.bing.com/dict/search?q=" + URLUtil.encodeURIComponent(selectedText);
        // System.out.println(url);
        BrowserUtil.browse(url);
    }
}
