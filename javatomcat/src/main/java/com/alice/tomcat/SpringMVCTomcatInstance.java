package com.alice.tomcat;

import com.alice.servlet.IndexServlet;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletException;
import java.io.File;

/**
 * 2019-11-21 15:21:17
 * 通过Java内置Tomcat运行SpringMVC框架
 * 原理:tomcat加载到SpringMVC注解方式启动,就会创建SpringMVC
 *
 * @author liusc
 */
public class SpringMVCTomcatInstance {

    private final static int port = 9098;

    private final static String contextPath = "/demo";

    public static void main(String[] args) {

        try {
            //启动Tomcat
            Tomcat tomcat = new Tomcat();

            //设置tomcat端口号
            tomcat.setPort(port);

            //设置tomcat关闭热部署
            tomcat.getHost().setAutoDeploy(false);

            //读取项目路径 加载静态资源
            String absolutePath = new File("javatomcat/src/main").getAbsolutePath();
            StandardContext standardContext = (StandardContext) tomcat.addWebapp(contextPath, absolutePath);

            //禁止重新载入
            standardContext.setReloadable(false);

            //class文件读取地址
            File classFiles = new File("target/classes");

            //创建WebRoot
            WebResourceRoot resource = new StandardRoot(standardContext);

            //tomcat内部读取class执行
            resource.addPreResources(new DirResourceSet(resource, "/WEB-INF/classes", classFiles.getAbsolutePath(), "/"));

            tomcat.start();
            System.out.println("tomcat run ...");
            tomcat.getServer().await();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }


    }
}
