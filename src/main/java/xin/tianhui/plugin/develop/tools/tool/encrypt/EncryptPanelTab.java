package xin.tianhui.plugin.develop.tools.tool.encrypt;

import javax.swing.*;

public class EncryptPanelTab {
    private JTabbedPane encryptTab;
    private JPanel mainPanel;

    public EncryptPanelTab(){
        Base64Panel base64Panel = new Base64Panel();
        EncryptPanel encryptPanel = new EncryptPanel();
        encryptTab.addTab("Base64",base64Panel.getMainPanel());
        encryptTab.addTab("Encrypt",encryptPanel.getMainPanel());
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
