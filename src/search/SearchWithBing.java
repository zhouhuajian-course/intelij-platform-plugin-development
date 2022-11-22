package search;

import com.intellij.ide.BrowserUtil;
import com.intellij.ide.fileTemplates.impl.UrlUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.util.io.URLUtil;

public class SearchWithBing extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        String selectedText = e.getRequiredData(CommonDataKeys.EDITOR).getCaretModel().getCurrentCaret().getSelectedText();
        BrowserUtil.browse("https://bing.com/search?q=" + URLUtil.encodeURIComponent(selectedText));
    }
}
