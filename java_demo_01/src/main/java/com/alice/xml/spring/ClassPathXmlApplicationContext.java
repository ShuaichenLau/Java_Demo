package com.alice.xml.spring;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.util.StringUtils;

import java.io.InputStream;
import java.util.List;

/**
 * 自定义Spring容器框架 xml方式实现
 * 2019年5月25日13:28:35
 */
public class ClassPathXmlApplicationContext {

    // xml读取路径地址
    private String xmlPath;

    public ClassPathXmlApplicationContext(String xmlPath) {
        this.xmlPath = xmlPath;
    }

    //使用方法参数beanId查找配置文件中bean节点的id信息是否一致. 返回class信息
    public String findByElementClass(List<Element> readerXML, String beanId){

        for (Element element : readerXML) {
            String xmlBeanId = element.attributeValue("id");
            if (xmlBeanId == null || xmlBeanId.isEmpty()){
                continue;
            }
            if (xmlBeanId.equals(beanId)){
                String xmlBeanClass = element.attributeValue("class");
                return xmlBeanClass;
            }
        }
        return null;
    }

    public Object getBean(String beanId) throws Exception {
        if(StringUtils.isEmpty(beanId)){
            throw new Exception("beanId不能为空");
        }

        // 1.解析xml文件 获取所有bean节点信息
        List<Element> elements = readXML();
        if (elements == null || elements.isEmpty()){
            throw new Exception("配置文件中,没有配置bean信息");
        }

        // 2.使用方法参数beanId查找配置文件中bean节点的Id信息是否一致.

        String elementClass = findByElementClass(elements, beanId);
        if(elementClass == null || elementClass.isEmpty()){
            throw new Exception("该bean对象没有配置class地址");
        }

//        for (Element element : elements) {
//            String xmlBeanId = element.attributeValue("id");
//            if(xmlBeanId == null || xmlBeanId.isEmpty()){
//                continue;
//            }
//
//            if (xmlBeanId.equals(beanId)){
//                String xmlClass = element.attributeValue("class");
//
//                if(xmlClass == null || xmlClass.isEmpty()){
//                    throw new Exception("配置文件中,没有配置class信息");
//                }
//
//                Object instance = newInstance(xmlClass);
//                return instance;
//            }
//        }
        // 3.获取class地址 使用反射机制初始化
        return newInstance(elementClass);
//        return null;
    }

    // 初始化Bean对象
    public Object newInstance(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> classInfo = Class.forName(className);
        Object o = classInfo.newInstance();
        return o;
    }

    // 解析xml文件
    public  List<Element> readXML() throws DocumentException {
        // 1.解析xml文件信息
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(getResourceAsStream(xmlPath));
        // 2.读取根节点
        Element rootElement = document.getRootElement();
        // 3.获取根节点下所有的子节点
        List<Element> elements = rootElement.elements();
        if(elements== null){
            return null;
        }
        return elements;
    }

    // 获取当前上下文
    public InputStream getResourceAsStream(String xmlPath){
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(xmlPath);
        return resourceAsStream;
    }


}
