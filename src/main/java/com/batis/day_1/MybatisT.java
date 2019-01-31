package com.batis.day_1;


import com.batis.dao.CityDao;
import com.batis.model.City;
import com.mysql.cj.api.Session;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangyongchao
 * @date 2019/1/7  10:25
 */
public class MybatisT {

    public static void main(String[] args) throws IOException {


        SqlSessionFactory sqlSession = new SqlSessionFactoryBuilder().build(new ClassPathResource("mybatis/mybatis-config.xml").getInputStream());
        CityDao dao = sqlSession.openSession().getMapper(CityDao.class);
        List<City> city=dao.getCityList();

        System.out.println("Arrays.toString(city) = " + city.toArray());

    }

}

