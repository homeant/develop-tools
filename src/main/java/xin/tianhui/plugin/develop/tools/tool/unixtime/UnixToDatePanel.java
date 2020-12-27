package xin.tianhui.plugin.develop.tools.tool.unixtime;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class UnixToDatePanel {
    private JPanel mainPanel;
    private JTextField timeText;
    private JComboBox dateType;
    private JButton convertButton;
    private JTextField dateText;

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public UnixToDatePanel() {
        dateType.addItem(new DateType("s", "秒"));
        dateType.addItem(new DateType("ms", "毫秒"));
        timeText.setMinimumSize(new Dimension(100, 0));
        timeText.setMaximumSize(new Dimension(100, 0));
        dateText.setMinimumSize(new Dimension(150, 0));
        dateText.setMaximumSize(new Dimension(150, 0));
        dateType.setMinimumSize(new Dimension(40,0));
        dateType.setMaximumSize(new Dimension(40,0));
        dateType.addActionListener(this::transform);
        convertButton.addActionListener(this::transform);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private void transform(ActionEvent e) {
        String timeValue = timeText.getText();
        DateType typeValue = (DateType) dateType.getSelectedItem();
        if (StringUtils.isNotBlank(timeValue) && typeValue != null) {
            if (StringUtils.equals(typeValue.getType(), "s")) {
                dateText.setText(new DateTime(Long.parseLong(timeValue) * 1000).toString(DATE_FORMAT));
            } else {
                dateText.setText(new DateTime(Long.parseLong(timeValue)).toString(DATE_FORMAT));
            }
        }
    }


}
