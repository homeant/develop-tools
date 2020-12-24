package xin.tianhui.plugin.develop.tools.tool.unixtime;

import com.intellij.ui.components.JBScrollPane;
import com.intellij.uiDesigner.core.GridConstraints;

import javax.swing.*;
import java.awt.*;

public class UnixTimePanel {
    private JPanel mainPanel;

    public UnixTimePanel(){
        JBScrollPane jScrollPane = new JBScrollPane();
        JPanel jPanel = new JPanel();
        jScrollPane.add(jPanel);
        jPanel.setLayout(new GridLayout(2,1));
        DateToUnixPanel dateToUnixPanel = new DateToUnixPanel();
        UnixToDatePanel unixToDatePanel = new UnixToDatePanel();
        jPanel.add("unixToDate",unixToDatePanel.getMainPanel());
        jPanel.add("dateToUnix",dateToUnixPanel.getMainPanel());
        mainPanel.add(jPanel,new GridConstraints());
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
