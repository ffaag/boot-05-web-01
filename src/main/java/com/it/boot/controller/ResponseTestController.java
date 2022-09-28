package com.it.boot.controller;

import com.it.boot.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author ZuYingFang
 * @time 2021-09-12 23:14
 */

@Controller
public class ResponseTestController {

    @ResponseBody
    @GetMapping("/test/person")
    public Person gerPerson(){

        Person person = new Person();
        person.setAge(28);
        person.setBirth(new Date());
        person.setName("zhangsan");
        return person;

    }

}
