package com.it.boot.config;

import com.it.boot.bean.Pet;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

/**
 * @author ZuYingFang
 * @time 2021-09-12 14:59
 */

@Configuration(proxyBeanMethods = false)
public class WebConfig implements WebMvcConfigurer {


    // 实现矩阵变量
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {

        UrlPathHelper urlPathHelper = new UrlPathHelper();

        // 不移除;号后面的内容，这样矩阵变量功能才能生效
        urlPathHelper.setRemoveSemicolonContent(false);

        configurer.setUrlPathHelper(urlPathHelper);
    }


    // 自己编写一个转换器，实现pojo类的自动注入的对象属性的注入
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new Converter<String, Pet>() {
            @Override
            public Pet convert(String s) {
                if (!StringUtils.isEmpty(s)) {
                    Pet pet = new Pet();
                    String[] split = s.split(",");
                    pet.setName(split[0]);
                    pet.setAge(split[1]);
                    return pet;
                }
                return null;
            }
        });
    }

}
