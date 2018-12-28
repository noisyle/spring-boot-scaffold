package com.chinanx.crypto.mybatis.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.chinanx.crypto.util.DESTool;

public class CryptoStringTypeHandler extends BaseTypeHandler<String> {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType)
            throws SQLException {
        try {
            logger.debug("i: {}, parameter: {}", i, parameter);
            ps.setString(i, DESTool.encrypt(parameter));
        } catch (Exception e) {
            logger.error(parameter, e);
        }
    }

    @Override
    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String str = rs.getString(columnName);
        if(StringUtils.hasLength(str)) {
            try {
                str = DESTool.decrypt(rs.getString(columnName));
            } catch (Exception e) {
                logger.error("{}: {}", columnName, rs.getString(columnName), e);
            }
        }
        return str;
    }

    @Override
    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String str = rs.getString(columnIndex);
        if(StringUtils.hasLength(str)) {
            try {
                str = DESTool.decrypt(rs.getString(columnIndex));
            } catch (Exception e) {
                logger.error("{}: {}", columnIndex, rs.getString(columnIndex), e);
            }
        }
        return str;
    }

    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String str = cs.getString(columnIndex);
        if(StringUtils.hasLength(str)) {
            try {
                str = DESTool.decrypt(cs.getString(columnIndex));
            } catch (Exception e) {
                logger.error("{}: {}", columnIndex, cs.getString(columnIndex), e);
            }
        }
        return str;
    }

}
