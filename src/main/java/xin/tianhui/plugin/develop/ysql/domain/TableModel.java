package xin.tianhui.plugin.develop.ysql.domain;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * @author xiaobang_1118
 */
public class TableModel extends AbstractTableModel {

    private final List<Row> rowList;

    private final List<Column> columnList;

    public TableModel(List<Column> columnList, List<Row> rowList) {
        this.columnList = columnList;
        this.rowList = rowList;
    }

    @Override
    public int getRowCount() {
        return rowList.size();
    }

    @Override
    public int getColumnCount() {
        return columnList.size();
    }

    @Override
    public String getColumnName(int column) {
        return columnList.get(column).getTitle();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Column column = columnList.get(columnIndex);
        return rowList.get(rowIndex).get(column.getKey());
    }
}
