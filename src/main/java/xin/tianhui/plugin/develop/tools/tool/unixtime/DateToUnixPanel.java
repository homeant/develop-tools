package xin.tianhui.plugin.develop.tools.tool.unixtime;

import com.intellij.notification.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.*;

import javax.swing.*;
import java.awt.*;

@Slf4j
public class DateToUnixPanel {
    private JTextField dateText;
    private JButton convertButton;
    private JTextField unixText;
    private JComboBox<DateType> dateType;
    private JPanel mainPanel;

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public DateToUnixPanel() {
        dateType.addItem(new DateType("s", "秒"));
        dateType.addItem(new DateType("ms", "毫秒"));

        dateText.setMinimumSize(new Dimension(156,0));
        unixText.setMinimumSize(new Dimension(156,0));
        dateType.setMaximumSize(new Dimension(50,0));
        convertButton.setMaximumSize(new Dimension(110,0));
        convertButton.addActionListener(e -> {
            try {
                String date = dateText.getText();
                DateType type = (DateType) dateType.getSelectedItem();
                if (StringUtils.isNotBlank(date) && type != null) {
                    DateTimeFormatter formatter = DateTimeFormat.forPattern(DATE_FORMAT);
                    DateTime dateTime = DateTime.parse(date, formatter);
                    if (StringUtils.equals("s", type.getType())) {
                        unixText.setText(dateTime.getMillis() / 1000 + "");
                    } else {
                        unixText.setText(dateTime.getMillis() + "");
                    }

                }
            } catch (Exception ex) {
                //NotificationUtils.notification("提示", "时间转换错误", NotificationType.ERROR);
                throw ex;
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
