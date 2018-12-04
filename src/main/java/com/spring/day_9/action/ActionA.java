package com.spring.day_9.action;


import com.spring.day_9.Config.annotion.JsonPrama;
import com.spring.day_9.bean.Pserson;
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
    @ResponseBody
    private Pserson methodB(Object o, Object o2) {

        return new Pserson().setAge(12).setName("wyc");

    }


    @RequestMapping("/request")
    private String request(@RequestBody Long lang, String string, String name) {

        System.out.println(lang + string);

        return "success!";

    }
}
