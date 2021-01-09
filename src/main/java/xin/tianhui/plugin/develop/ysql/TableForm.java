package xin.tianhui.plugin.develop.ysql;

import com.intellij.ui.table.JBTable;
import xin.tianhui.plugin.develop.ysql.domain.TableModel;

import javax.swing.*;
import java.awt.*;

public class TableForm {

    private JPanel mainPanel;

    private final TableModel tableModel;

    public TableForm(TableModel tableModel) {
        this.tableModel = tableModel;
        mainPanel.setLayout(new BorderLayout());
        JBTable table = new JBTable(tableModel);
        mainPanel.add(table.getTableHeader(), BorderLayout.NORTH);
        // 把 表格内容 添加到容器中心
        mainPanel.add(table, BorderLayout.CENTER);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
