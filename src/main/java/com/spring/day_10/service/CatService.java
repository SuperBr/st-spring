package com.spring.day_10.service;

import com.spring.day_10.api.ICatService;
import com.spring.day_10.model.Cat;

public class CatService implements ICatService {
    @Override
    public Cat printCat(Cat cat) {
        System.out.println(cat);
        return cat.setAge(12);
    }

}
