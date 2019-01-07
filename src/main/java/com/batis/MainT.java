package com.batis;

import com.alibaba.druid.pool.DruidDataSource;
import com.batis.dao.CityDao;
import com.batis.model.City;
import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.ibatis.transaction.managed.ManagedTransactionFactory;
import org.springframework.core.io.ClassPathResource;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author wangyongchao
 * @date 2018/12/20  10:49
 */
public class MainT {


    public static void main(String[] args) throws IOException {

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        Configuration configuration = new Configuration();

        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");

        dataSource.setUrl("jdbc:mysql://192.168.146.130:3306/suber");

        dataSource.setUsername("root");

        dataSource.setPassword("123456");

        dataSource.setValidationQuery("select 1");

        Environment environment = new Environment("id", new JdbcTransactionFactory(), dataSource);

        configuration.setEnvironment(environment);

        configuration.addMapper(CityDao.class);


        String resource = "mybatis/CityDao.xml";


        InputStream inputStream = new ClassPathResource(resource).getInputStream();

        XMLMapperBuilder mapperParser = new XMLMapperBuilder(inputStream, configuration, resource, configuration.getSqlFragments());

        mapperParser.parse();


        SqlSessionFactory session = sqlSessionFactoryBuilder.build(configuration);

        SqlSession sqlSession = session.openSession();

        CityDao cityDao = sqlSession.getMapper(CityDao.class);

        City result = cityDao.getById(1L);

        cityDao.getCityList();

        sqlSession.close();

    }


}
