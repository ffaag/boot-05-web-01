package com.it.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author ZuYingFang
 * @time 2021-09-12 14:30
 */

@Controller
public class RequestController {

    // 共享域中共享数据，用request，得到数据时不需要getAttribute，直接用注解@RequestAttribute("message")

    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request){
        request.setAttribute("message", "成功了");
        return "forward:/success";
    }


    @GetMapping("/params")
    public String testParam(Map<String, Object> map,
                            Model model,
                            HttpServletRequest request,
                            HttpServletResponse response){

        map.put("hello", "world666");

        model.addAttribute("world", "hello6666");

        request.setAttribute("message", "hello");

        Cookie cookie = new Cookie("c1", "V1");
        response.addCookie(cookie);


        return "forward:/success";
    }



    @ResponseBody   // 直接将返回值显示到浏览器上
    @GetMapping("/success")
    // @RequestAttribute("message")直接把request域中的message数据传给msg
    public String success(@RequestAttribute("message") String msg){

        return msg;
    }
}
