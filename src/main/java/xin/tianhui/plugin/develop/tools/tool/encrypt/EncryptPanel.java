package xin.tianhui.plugin.develop.tools.tool.encrypt;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import xin.tianhui.plugin.develop.tools.utils.AESUtils;
import xin.tianhui.plugin.develop.tools.utils.DESUtils;

import javax.swing.*;

@Slf4j
public class EncryptPanel {
    private JPanel mainPanel;
    private JEditorPane plainText;
    private JEditorPane cipherText;
    private JButton encryptButton;
    private JButton decodeButton;
    private JRadioButton AESRadioButton;
    private JRadioButton DESRadioButton;
    private JTextField password;
    private String encryptType;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public EncryptPanel() {
        radioAction(AESRadioButton);
        radioAction(DESRadioButton);
        encryptButton.addActionListener((e) -> {
            String text = plainText.getText();
            if (StringUtils.isNotBlank(text)) {
                cipherText.setText(encrypt(encryptType, text));
            }
        });
        decodeButton.addActionListener((e) -> {
            String text = cipherText.getText();
            if (StringUtils.isNotBlank(text)) {
                plainText.setText(decode(encryptType, text));
            }
        });
    }

    public String encrypt(String type, String text) {
        String encryptText = "";
        try {
            switch (type) {
                case "AES":
                    encryptText = AESUtils.encrypt(text, password.getText());
                    break;
                case "DES":
                    encryptText = DESUtils.encrypt(text, password.getText());
                    break;
                default:

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return encryptText;
    }

    public String decode(String type, String text) {
        String encryptText = "";
        try {
            switch (type) {
                case "AES":
                    encryptText = AESUtils.decode(text, password.getText());
                    break;
                case "DES":
                    encryptText = DESUtils.decode(text, password.getText());
                    break;
                default:

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return encryptText;
    }

    public void radioAction(JRadioButton component) {
        component.addActionListener((e) -> {
            encryptType = component.getText();
        });
    }
}
