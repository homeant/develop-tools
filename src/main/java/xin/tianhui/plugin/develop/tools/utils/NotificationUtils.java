package xin.tianhui.plugin.develop.tools.utils;

import com.intellij.notification.*;

public class NotificationUtils {

    private static final String GROUP = "Develop Tool Notification";

    public static void notification(String title, String content, NotificationType notificationType) {
        NotificationGroup notificationGroup = NotificationGroupManager.getInstance().getNotificationGroup(GROUP);
        Notification notification = notificationGroup.createNotification(title, content, notificationType, null);
        Notifications.Bus.notify(notification);
    }
}
