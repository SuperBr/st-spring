package com.spring.day_9.test;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonTest {


    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        Long a=12l;

        String st = objectMapper.writeValueAsString(Long.valueOf(12));

        System.out.println(st);




        String json = "12";


        Long aLong = objectMapper.readValue(json, Long.class);

        System.out.println(aLong);
    }
}
