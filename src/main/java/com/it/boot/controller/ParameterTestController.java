package com.it.boot.controller;

import com.it.boot.bean.Person;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZuYingFang
 * @time 2021-09-12 13:47
 */

@RestController
public class ParameterTestController {
                                               


    @PostMapping("/saveuser")
    public Person saveUser(Person person){

        return person;
    }

                                               

    // 占位符与@PathVariable实现传参，可以直接给一个map接收所有，不推荐map，到时候自己也不知道key了
    // 接收头部信息用@RequestHeader
    // 参数一致直接写，参数名不一样用@RequestParam，可以给一个map接收所有
    // 接收cookie用CookieValue
    @GetMapping("/car/{id}/owner/{username}")
    public Map<String, Object> getCar(@PathVariable("id") String id,
                                      @PathVariable("username") String username,
                                      @PathVariable Map<String, String> pv,
                                      @RequestHeader("User-Agent") String userAgent,
                                      @RequestHeader Map<String, String> header,
                                      @RequestParam("age") Integer age,
                                      @RequestParam("inters") List<String> inters,
                                      @RequestParam Map<String, String> params,
                                      @CookieValue("Webstorm-4eab547a") String webstorm_4eab547a,
                                      @CookieValue("Webstorm-4eab547a") Cookie cookie){

        HashMap<String, Object> map = new HashMap<>();
        /*map.put("id", id);
        map.put("username", username);
        map.put("pv", pv);
        map.put("userAgent", userAgent);
        map.put("header", header);*/

        map.put("age", age);
        map.put("inters", inters);
        map.put("Webstorm-4eab547a", webstorm_4eab547a);


        map.put("params", params);

        System.out.println(cookie.getName());


        return map;
    }

    // @RequestBody将表单提交的信息放到content中
    @PostMapping("/save")
    public Map postMethod(@RequestBody String content){

        HashMap<String, Object> map = new HashMap<>();

        map.put("content", content);

        return map;
    }


    //  /cars/sell;low=34;brand=byd,audi,yd  ；矩阵变量
    // springboot默认禁用了矩阵变量的功能，要自行手动开启
    // 矩阵变量必须要有url路径变量才能被解析，就是路径后面会有一个分号，那么这个分号前面的路径要用大括号括起来
    @GetMapping("/cars/{path}")
    public Map carsSell(@MatrixVariable("low") Integer low,
                        @MatrixVariable("brand") List<String> brand,
                        @PathVariable("path") String path) {
        HashMap<String, Object> map = new HashMap<>();

        map.put("low", low);
        map.put("brand", brand);
        map.put("path", path);
        return map;
    }



    //   /boss/1;age=20/2;age=10
    @GetMapping("/boss/{bossId}/{empId}")
    public Map boss(@MatrixVariable(value = "age", pathVar = "bossId") Integer bossAge,
                    @MatrixVariable(value = "age", pathVar = "empId") Integer empAge){

        HashMap<String, Object> map = new HashMap<>();

        map.put("bossAge", bossAge);
        map.put("empAge", empAge);

        return map;
    }
}
