package org.geektimes.projects.user.web.listener;

import org.geektimes.MyJmx.MyXiao;
import org.geektimes.MyJmx.MyXiaoManager;
import org.geektimes.context.ComponentContext;

import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.lang.management.ManagementFactory;
import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.management.UserManager;

/**
 * {@link ComponentContext} 初始化器
 * ContextLoaderListener
 */
public class ComponentContextInitializerListener implements ServletContextListener {

    private ServletContext servletContext;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        this.servletContext = sce.getServletContext();
        ComponentContext context = new ComponentContext();
        context.init(servletContext);
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName = null;
        try {
            objectName = new ObjectName("org.geektimes.MyJmx:type=myXiao");
            MyXiao user = new MyXiao();
            mBeanServer.registerMBean(createMyXiaoMBean(user),objectName);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
//        ComponentContext context = ComponentContext.getInstance();
//        context.destroy();
    }
    private static Object createUserMBean(User user) throws Exception {
        return new UserManager(user);
    }
    private static Object createMyXiaoMBean(MyXiao user) throws Exception {
        return new MyXiaoManager(user);
    }
}
