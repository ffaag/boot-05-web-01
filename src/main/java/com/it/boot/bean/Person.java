package com.it.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author ZuYingFang
 * @time 2021-09-12 20:58
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String name;

    private Integer age;

    private Date birth;

    private Pet pet;

}
