package com.spring.day_9.action;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
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
    private Object methodB(Object o, Object o2) {

        return o;

    }
}
