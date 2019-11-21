package com.alice.tomcat;

import com.alice.servlet.IndexServlet;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.springframework.core.env.SystemEnvironmentPropertySource;

/**
 * 使用Java语言创建Tomcat服务器
 * Tomcat底层执行 Servlet程序
 * SpringMVC底层使用Servlet包装
 *
 * 以注解的方式启动SpringMVC
 *
 * @author scliuk
 * 2019-11-21 00:28:09
 */
public class JavaTomcatInstance {

    private final static int port = 9098;
    private final static String path = "/demo";

    public static void main(String[] args) {


        //创建tomcat服务器
        Tomcat tomcatServer = new Tomcat();
        //指定端口号
        tomcatServer.setPort(port);
        //是否设置自动部署
        tomcatServer.getHost().setAutoDeploy(false);
        //创建上下文
        StandardContext standardContext = new StandardContext();
        //设置上下文路径
        standardContext.setPath(path);
        //监听上下文
        standardContext.addLifecycleListener(new Tomcat.FixContextListener());
        //将tomcat添加standardContext
        tomcatServer.getHost().addChild(standardContext);

        //web.xml
        //创建Servlet
        tomcatServer.addServlet(path,"IndexServlet", new IndexServlet());
        //添加Servlet映射
        standardContext.addServletMappingDecoded("/index","IndexServlet");

        try {
            tomcatServer.start();
            System.out.println("tomcat start done...");
            //异步进行请求
            tomcatServer.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }

    }

}
