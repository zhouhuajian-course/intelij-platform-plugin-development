package learn;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import org.jetbrains.annotations.NotNull;

public class SimpleAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
        System.out.println(anActionEvent.getData(CommonDataKeys.PROJECT));
        System.out.println(anActionEvent.getData(CommonDataKeys.EDITOR));
        System.out.println("Simple Action!");
    }
}












