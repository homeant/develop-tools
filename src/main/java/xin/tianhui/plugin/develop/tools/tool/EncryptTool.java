package xin.tianhui.plugin.develop.tools.tool;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;
import xin.tianhui.plugin.develop.tools.tool.encrypt.Base64Panel;
import xin.tianhui.plugin.develop.tools.tool.encrypt.EncryptPanel;

import javax.swing.*;

public class EncryptTool implements ToolWindowFactory {


    private JPanel rootPanel;
    private JTabbedPane tabPanel;

    public EncryptTool() {
        tabPanel.removeAll();
        tabPanel.addTab("BASE64", new Base64Panel().getMainPanel());
        tabPanel.addTab("Encrypt", new EncryptPanel().getMainPanel());
    }

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        Content content = contentFactory.createContent(rootPanel, "", false);
        toolWindow.getContentManager().addContent(content);

    }
}
