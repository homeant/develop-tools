package xin.tianhui.plugin.develop.tools.tool;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.components.JBTabbedPane;
import com.intellij.ui.content.*;
import org.jetbrains.annotations.NotNull;
import xin.tianhui.plugin.develop.tools.tool.encrypt.EncryptPanelTab;
import xin.tianhui.plugin.develop.tools.tool.json.JsonViewPanel;
import xin.tianhui.plugin.develop.tools.tool.unixtime.UnixTimePanel;

import java.awt.*;

/**
 * 工具工厂
 * @author xiaobang_1118
 */
public class DevelopToolWindowFactory implements ToolWindowFactory {
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();

        JBTabbedPane toolTabs = new JBTabbedPane();
        toolTabs.setMinimumSize(new Dimension(700,0));
        JsonViewPanel jsonViewTool = new JsonViewPanel();
        toolTabs.addTab("JSON",jsonViewTool.getMainPanel());
        EncryptPanelTab encryptTab = new EncryptPanelTab();
        toolTabs.addTab("Encrypt",encryptTab.getMainPanel());
        UnixTimePanel unixTimePanel = new UnixTimePanel();
        toolTabs.addTab("UnixTime",unixTimePanel.getMainPanel());
        Content content = contentFactory.createContent(toolTabs, "", false);
        ContentManager contentManager = toolWindow.getContentManager();
        contentManager.addContent(content);
    }
}
