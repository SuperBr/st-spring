package com.spring.day_9.action;


import com.spring.day_9.Config.annotion.JsonPrama;
import com.spring.day_9.bean.Pserson;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;

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
    @ResponseBody
    private LangModel request(@RequestBody LangModel lang, String wyc,Pserson pserson) {



        System.out.println(lang );

        return lang;

    }

    public static class  LangModel{

        private Long lang;

        private String name;

        public Long getLang() {
            return lang;
        }

        public LangModel setLang(Long lang) {
            this.lang = lang;
            return this;
        }

        public String getName() {
            return name;
        }

        public LangModel setName(String name) {
            this.name = name;
            return this;
        }
    }
}
