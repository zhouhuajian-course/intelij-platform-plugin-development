package actionGroup;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

/**
 * 静态ActionGroup，里面的Action不会动态改变
 * Action可以配置在plugin.xml的group标签里面
 */
public class StaticActionGroup extends DefaultActionGroup {

    @Override
    public void update(@NotNull AnActionEvent e) {
        Project project = e.getProject();
        Editor editor = e.getData(CommonDataKeys.EDITOR);
        e.getPresentation().setEnabled(project != null && editor != null);
    }
}
