package com.di;

import com.di.entity.Delimiter;
import com.di.service.DelimiterService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by beerman on 23.02.2017.
 */
@RestController
public class MainController {


    DelimiterService delimiterService;
    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

    @RequestMapping(value = "/comma", params = "text")
    @ResponseBody
    public String delimit(@RequestParam(value = "text") String text){
        delimiterService = (DelimiterService) context.getBean("delimiterService");
        return delimiterService.delimit(text);

    }
}
