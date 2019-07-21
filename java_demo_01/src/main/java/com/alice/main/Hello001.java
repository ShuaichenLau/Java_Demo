package com.alice.main;

import com.alice.entity.User;
import com.alice.service.Uservice;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.SimpleFormatter;

public class Hello001 {

    public static void main(String[] args) {
        int i = 0;
        System.out.println(++i);
        System.out.println(++i);

        System.out.println(System.currentTimeMillis());
        System.out.println(true == false);

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Uservice userService = (Uservice)classPathXmlApplicationContext.getBean("userService");
        User user = new User();
        user.setId(1);
        user.setName("alice");
        user.setAddress("beijing");
        user.setAge(20);
        userService.insertUser(user);

        Hello001 hello001 = new Hello001();
        hello001.test001();

        System.out.println("========================================");


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        Calendar calendar = Calendar.getInstance();

        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));

        calendar.setTimeZone(TimeZone.getTimeZone("America/New_York"));

        System.out.println(calendar.getTime());
        System.out.println(simpleDateFormat.format(calendar.getTime()));

    }


    public void test001(){
        SAXReader saxReader = new SAXReader();
        try {
            //读取xml文件
            Document document = saxReader.read(getResourceAsStream("spring.xml"));
            // 读取根节点
            Element rootElement = document.getRootElement();
            getNodes(rootElement);

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public void getNodes(Element element){
        System.out.print("获取节点名称: " + element.getName());
        //获取属性方法
        List<Attribute> attributes = element.attributes();
        for (Attribute attribute : attributes) {
            System.out.println(attribute.getName() + "==" + attribute.getText());
        }
        //获取属性value
        String textTrim = element.getTextTrim();
        if (StringUtils.isEmpty(textTrim)){
            System.out.print("textTrim==>" + textTrim);
        }

        //使用迭代器 子节点信息
        Iterator<Element> iterator = element.elementIterator();
        while (iterator.hasNext()){
            Element next = iterator.next();
            getNodes(next);
        }
    }

    public InputStream getResourceAsStream(String xml){
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(xml);
        return resourceAsStream;

    }
}
