package xin.tianhui.plugin.develop.tools.tool.unixtime;

import javax.swing.*;
import java.awt.*;

public class UnixTimePanel {
    private JPanel mainPanel;

    public UnixTimePanel(){
        mainPanel.setLayout(new GridLayout(2,1));
        DateToUnixPanel dateToUnixPanel = new DateToUnixPanel();
        UnixToDatePanel unixToDatePanel = new UnixToDatePanel();
        mainPanel.add(unixToDatePanel.getMainPanel());
        mainPanel.add(dateToUnixPanel.getMainPanel());
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
