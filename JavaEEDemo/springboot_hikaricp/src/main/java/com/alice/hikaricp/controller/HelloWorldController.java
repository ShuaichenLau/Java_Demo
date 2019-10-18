package com.alice.hikaricp.controller;

import com.alice.hikaricp.entity.Person;
import com.alice.hikaricp.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

import static com.alice.hikaricp.utils.SystemUtil.println;

/**
 * HelloWorldDemo
 */
@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    private final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @Resource
    private DataSource dataSource;

    @Autowired
    private IUserService userService;

    @ResponseBody
    @RequestMapping("/showConfig")
    public String index() {

        logger.info("com.alice.hikaricp.controller.HelloWorldController.index");

        logger.info("dataSource ==>  " + dataSource.getClass());

        logger.info("userService ==>  " + userService.getClass());

        println("import static ");
        return "Greetings from Spring Boot! ";


    }

    @RequestMapping("/index")
    public String indexHtml(Model model){

        Person single = new Person("hyj",21);
        List<Person> people = new ArrayList<Person>();
        Person p1 = new Person("dlp",21);
        Person p2 = new Person("tq",21);
        Person p3 = new Person("mk",21);
        people.add(p1);
        people.add(p2);
        people.add(p3);
        model.addAttribute("singlePerson",single);
        model.addAttribute("people",people);
        return "index";

    }



}
