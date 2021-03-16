package org.geektimes.MyJmx;

import org.geektimes.projects.user.management.UserManager;

import javax.management.MBeanInfo;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.StandardMBean;
import java.lang.management.ManagementFactory;

public class XiaoTest {
    public static void main(String[] args) throws Exception {
        // 获取平台 MBean Server
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        // 为 UserMXBean 定义 ObjectName
        ObjectName objectName = new ObjectName("org.geektimes.MyJmx:type=myXiao");
        // 创建 UserMBean 实例
        MyXiao user = new MyXiao();
        mBeanServer.registerMBean(createMyXiaoMBean(user), objectName);
        while (true) {
            Thread.sleep(2000);
            System.out.println(user);
        }
    }
    private static Object createMyXiaoMBean(MyXiao user) throws Exception {
        return new MyXiaoManager(user);
    }
}
