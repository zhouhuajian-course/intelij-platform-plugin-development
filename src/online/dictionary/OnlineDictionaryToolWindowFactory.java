package online.dictionary;


import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentManager;
import org.jetbrains.annotations.NotNull;

public class OnlineDictionaryToolWindowFactory implements ToolWindowFactory {

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        // toolWindow是当前工具窗口对象
        ContentManager contentManager = toolWindow.getContentManager();
        // displayName是单个Tab标签的标题
        // displayName @Nullable
//        Content content = contentManager.getFactory().createContent(
//                new OnlineDictionaryPanel(), null, true);
//        contentManager.addContent(content);

        Content content2 = contentManager.getFactory().createContent(
                new online.dictionary.OnlineDictionaryPanel(), "123", true);
        contentManager.addContent(content2);

        Content content3 = contentManager.getFactory().createContent(
                new online.dictionary.OnlineDictionaryPanel(), "456", true);
        contentManager.addContent(content3);

        Content content4 = contentManager.getFactory().createContent(
                new online.dictionary.OnlineDictionaryPanel(), "789", true);
        contentManager.addContent(content4);
    }

}
