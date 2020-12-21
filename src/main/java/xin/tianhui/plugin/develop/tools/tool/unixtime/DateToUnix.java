package xin.tianhui.plugin.develop.tools.tool.unixtime;

import com.google.common.collect.Lists;

import javax.swing.*;
import java.util.List;

public class DateToUnix {
    private JTextField dateText;
    private JButton convertButton;
    private JTextField unixText;
    private JComboBox dateType;
    private JPanel mainPanel;

    public DateToUnix(){
        dateType.addItem(new DateType("s","秒"));
        dateType.addItem(new DateType("ms","毫秒"));
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
