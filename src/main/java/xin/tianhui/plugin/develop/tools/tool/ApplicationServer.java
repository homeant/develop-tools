package xin.tianhui.plugin.develop.tools.tool;

import com.intellij.notification.*;
import com.intellij.notification.impl.NotificationGroupEP;
import com.intellij.openapi.components.ServiceManager;

public class ApplicationServer {

    public static ApplicationServer getInstance() {
        return ServiceManager.getService(ApplicationServer.class);
    }


}
