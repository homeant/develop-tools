package xin.tianhui.plugin.develop.tools.tool.unixtime;

import javax.swing.*;
import java.awt.*;

public class UnixTimePanel {
    private JPanel mainPanel;

    public UnixTimePanel() {
        mainPanel.setLayout(new FlowLayout());
        JPanel dataToUnixPanel = new DateToUnixPanel().getMainPanel();
        JPanel unixToDatePanel = new UnixToDatePanel().getMainPanel();
        this.mainPanel.add(unixToDatePanel);
        this.mainPanel.add(dataToUnixPanel);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
