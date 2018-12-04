package com.spring.day_9.action;


import com.spring.day_9.Config.annotion.JsonPrama;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
@RequestMapping
public class ActionA {

    @RequestMapping("/wel")
    private void methodA(Long lang,String string ) {

        System.out.println(lang + string);

    }
    @RequestMapping("/object")
    private Object methodB(@JsonPrama Object o, Object o2) {

        return o;

    }


    @RequestMapping("/request")
    private String request(@RequestBody Long lang, @RequestBody String string, String name) {

        System.out.println(lang + string);

        return "success!";

    }
}
