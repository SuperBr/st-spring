package com.batis;

import com.alibaba.druid.pool.DruidDataSource;
import com.batis.dao.CityDao;
import org.apache.ibatis.binding.MapperProxyFactory;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.SimpleExecutor;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.defaults.DefaultSqlSession;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.managed.ManagedTransaction;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author wangyongchao
 * @date 2019/1/2  10:31
 */
public class MapperProxyFactoryT {
    public static void main(String[] args) throws SQLException {

        MapperProxyFactory mapperProxyFactory = new MapperProxyFactory(CityDao.class);

        DataSource dataSource = new DruidDataSource();
        Configuration configuration = new Configuration();



        Transaction transaction = new ManagedTransaction(dataSource.getConnection(), Boolean.TRUE);

        Executor executor = new SimpleExecutor(configuration,transaction);

        SqlSession sqlSession = new DefaultSqlSession(configuration,executor);

    }
}
