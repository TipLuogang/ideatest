package com.itheima.boot1.demo1.controller;

import com.itheima.boot1.demo1.pojo.MailProperties;
import com.itheima.boot1.demo1.pojo.User;
import com.itheima.boot1.demo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private MailProperties mailProperties;

    @Resource
    private Environment env;

    @Value("${name}")
    private String name;

    @Autowired
    private UserService userService;

//    @GetMapping("/")
//    public String welcome(Map<String, Object> model) {
//        model.put("time", new Date());
//        model.put("message", "你好啊~~");
//        return "index";
//    }

    @RequestMapping("/pro")
    @ResponseBody
    public String show5(){
        return mailProperties.getHost() + "<br>"
                + mailProperties.getPort() + "<br>"
                + mailProperties.getUsername()+ "<br>"
                + mailProperties.getPassword();
    }

    @RequestMapping("/findBypage")
    @ResponseBody
    public List<User> show4(){
        String name1 = env.getProperty("name");
        System.out.println("name:" + name);
        System.out.println("name1:" + name1);
        return userService.getUserListByPage();
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<User> show3(){
        return userService.findAllUser();
    }

    @RequestMapping("/user/show")
    @ResponseBody
    public String show(){
        return "test你好";
    }

    @RequestMapping("/freemarker")
    public String show1(Model model){
        model.addAttribute("message", "Hello freemarker");
        return "demo";
    }
}
