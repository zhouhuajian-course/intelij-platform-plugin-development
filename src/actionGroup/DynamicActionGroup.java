package actionGroup;

import com.intellij.openapi.actionSystem.ActionGroup;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DynamicActionGroup extends ActionGroup {
    @Override
    public AnAction[] getChildren(@Nullable AnActionEvent e) {
        int arrLen = 0;
        AnAction action1 = null;
        AnAction action2 = null;
        if (e.getProject() != null) {
            arrLen = 1;
            action1 = new SimpleAction("Action created at runtime.");
            if (e.getData(CommonDataKeys.EDITOR) != null) {
                arrLen = 2;
                action2 = new SimpleAction("Another action created at runtime.");
            }
        }
        return arrLen == 0 ? new AnAction[0] : (arrLen == 1 ? new AnAction[]{action1} : new AnAction[]{action1, action2});

    }
}
