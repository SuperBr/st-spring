package com.batis.model;

/**
 * @author wangyongchao
 * @date 2018/12/29  11:05
 */
public class City {

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public City setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public City setName(String name) {
        this.name = name;
        return this;
    }
}
