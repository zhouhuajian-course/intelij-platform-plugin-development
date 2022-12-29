package actionGroup;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.pom.Navigatable;
import org.jetbrains.annotations.NotNull;

public class SimpleAction extends AnAction {

    SimpleAction() {
    }

    SimpleAction(String text) {
        super(text);
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Messages.showMessageDialog(
                e.getProject(),
                "Hello Everyone!",
                "A title",
                Messages.getInformationIcon());
    }
}












