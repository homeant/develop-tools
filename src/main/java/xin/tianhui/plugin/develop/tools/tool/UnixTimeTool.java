package xin.tianhui.plugin.develop.tools.tool;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;
import xin.tianhui.plugin.develop.tools.tool.unixtime.DateToUnix;
import xin.tianhui.plugin.develop.tools.tool.unixtime.UnixToDate;

import javax.swing.*;

public class UnixTimeTool implements ToolWindowFactory {

    private JPanel mainPanel;

    public UnixTimeTool(){
//        UnixToDate unixToDate = new UnixToDate();
//        mainPanel.add(unixToDate.getMainPanel());
        DateToUnix dateToUnix = new DateToUnix();
        mainPanel.add(dateToUnix.getMainPanel());

    }

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        Content content = contentFactory.createContent(mainPanel, "", false);
        toolWindow.getContentManager().addContent(content);
    }
}
