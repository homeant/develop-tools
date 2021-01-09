package xin.tianhui.plugin.develop.ysql;

import com.google.common.collect.Lists;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.*;
import org.jetbrains.annotations.NotNull;
import xin.tianhui.plugin.develop.ysql.domain.*;

public class TableWindowFactory implements ToolWindowFactory {
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();

        Column column = new Column();
        column.setTitle("test");
        column.setKey("test");
        Row row = new Row();
        row.put("test", "hello");
        TableModel tableModel = new TableModel(Lists.newArrayList(column), Lists.newArrayList(row));
        TableForm tableForm = new TableForm(tableModel);
        Content content = contentFactory.createContent(tableForm.getMainPanel(), "", false);
        ContentManager contentManager = toolWindow.getContentManager();
        contentManager.addContent(content);
    }
}
