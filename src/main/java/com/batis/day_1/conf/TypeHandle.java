package com.batis.day_1.conf;

import com.batis.constans.CityEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wangyongchao
 * @date 2019/1/11  13:52
 */
public class TypeHandle implements TypeHandler {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        for (Map.Entry<Short, String> shortStringEntry : CityEnum.TypeEnum.maps().entrySet()) {
            if (shortStringEntry.getValue().equals(parameter)) {
                ps.setShort(i, shortStringEntry.getKey());
            }
        }

    }

    @Override
    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return CityEnum.TypeEnum.getValue(rs.getShort(columnName));
    }

    @Override
    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return CityEnum.TypeEnum.getValue(rs.getShort(columnIndex));
    }

    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return CityEnum.TypeEnum.getValue(cs.getShort(columnIndex));
    }
}

