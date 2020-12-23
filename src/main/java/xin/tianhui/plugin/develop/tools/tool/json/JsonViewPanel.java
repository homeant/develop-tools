package xin.tianhui.plugin.develop.tools.tool.json;

import com.google.common.collect.Lists;
import com.google.gson.*;
import com.intellij.openapi.ui.Messages;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.event.*;
import java.util.List;
import java.util.Map;

public class JsonViewPanel {

    private JPanel mainPanel;
    private JTabbedPane tabPanel;
    private JButton formatButton;
    private JButton escapeButton;
    private JButton compressButton;
    private JTextArea jsonText;
    private JTree jsonTree;

    public JsonViewPanel() {
        initMenu();
        jsonTree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("JSON")));
        formatButton.addActionListener(e -> {
            String json = jsonText.getText();
            if (StringUtils.isNotBlank(json)) {
                //在滚动面板中显示列表
                jsonText.setText(formatJson(json));
                showJsonTree(json);
            }
        });
        escapeButton.addActionListener(e -> {
            String json = jsonText.getText();
            if (StringUtils.isNotBlank(json)) {
                jsonText.setText(StringEscapeUtils.unescapeJava(json));
                showJsonTree(json);
            }
        });
        compressButton.addActionListener(e -> {
            String json = jsonText.getText();
            if (StringUtils.isNotBlank(json)) {
                jsonText.setText(compressJson(json));
                showJsonTree(json);
            }
        });

    }

    private void initMenu() {
        JPopupMenu tabMenu = new JPopupMenu();
        JMenuItem menuItem = new JMenuItem("新建");
        menuItem.addActionListener(e -> {
                //Messages.showDialog("aaaaa","提示",new String[]{"OK"},0,Messages.getInformationIcon());

        });
        tabMenu.add(menuItem);
        tabPanel.setComponentPopupMenu(tabMenu);
    }

    private List<DefaultMutableTreeNode> getTreeNodeList(String json) {
        List<DefaultMutableTreeNode> lists = Lists.newArrayList();
        JsonElement jsonElement = getJsonElement(json);
        if (jsonElement.isJsonArray()) {
            JsonArray jsonArray = jsonElement.getAsJsonArray();
            for (int i = 0; i < jsonArray.size(); i++) {
                lists.add(getTreeNode(i, jsonArray.get(i)));
            }
        } else {
            JsonObject jsonObject = (JsonObject) jsonElement;
            for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                lists.add(getTreeNode(entry.getKey(), entry.getValue()));
            }
        }
        return lists;
    }

    public DefaultMutableTreeNode getTreeNode(Object key, JsonElement jsonElement) {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode();
        node.setUserObject(key);
        if (jsonElement.isJsonObject()) {
            JsonObject jsonObject = (JsonObject) jsonElement;
            for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                node.add(getTreeNode(entry.getKey(), entry.getValue()));
            }
        } else if (jsonElement.isJsonArray()) {
            JsonArray jsonArray = (JsonArray) jsonElement;
            for (int i = 0; i < jsonArray.size(); i++) {
                node.add(getTreeNode(i, jsonArray.get(i)));
            }
        } else if (jsonElement.isJsonPrimitive()) {
            JsonPrimitive jsonPrimitive = jsonElement.getAsJsonPrimitive();
            StringBuilder builder = new StringBuilder(key + ": ");
            if (jsonPrimitive.isString()) {
                builder.append("\"").append(jsonElement.getAsString()).append("\"");
            } else {
                builder.append(jsonElement.getAsString());
            }
            node.setUserObject(builder.toString());
        }
        return node;
    }


    public JsonElement getJsonElement(String json) {
        return JsonParser.parseString(json);
    }

    public String formatJson(String json) {
        JsonElement jsonElement = JsonParser.parseString(json);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(jsonElement);
    }

    public String compressJson(String json) {
        JsonElement jsonElement = JsonParser.parseString(json);
        return jsonElement.toString();
    }

    public void showJsonTree(String json) {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("JSON");
        List<DefaultMutableTreeNode> treeNodeList = getTreeNodeList(json);
        treeNodeList.forEach(root::add);
        jsonTree.setModel(new DefaultTreeModel(root));
    }


    public JPanel getMainPanel() {
        return this.mainPanel;
    }
}
