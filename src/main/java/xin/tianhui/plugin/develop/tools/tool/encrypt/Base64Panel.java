package xin.tianhui.plugin.develop.tools.tool.encrypt;

import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Panel {
    private JPanel mainPanel;
    private JEditorPane plainText;
    private JEditorPane cipherText;
    private JButton encryptButton;
    private JButton decodeButton;

    public Base64Panel(){
        encryptButton.addActionListener((e)->{
            String text = plainText.getText();
            if(StringUtils.isNotBlank(text)){
                byte[] encode = Base64.getEncoder().encode(text.getBytes(StandardCharsets.UTF_8));
                cipherText.setText(new String(encode));
            }
        });
        decodeButton.addActionListener((e)->{
            String text = cipherText.getText();
            if(StringUtils.isNotBlank(text)){
                byte[] decode = Base64.getDecoder().decode(text.getBytes(StandardCharsets.UTF_8));
                plainText.setText(new String(decode));
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
