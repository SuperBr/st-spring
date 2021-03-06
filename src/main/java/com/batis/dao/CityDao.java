package com.batis.dao;

import com.batis.model.City;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author wangyongchao
 * @date 2018/12/29  11:05
 */
public interface CityDao {

    @Select("select * from  city  where id =#{id}")
    City getById(Long id);


    List<City> getCityList();
}
