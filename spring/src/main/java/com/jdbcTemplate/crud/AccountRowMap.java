package com.jdbcTemplate.crud;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

//定义Account的封装策略
public class AccountRowMap implements RowMapper<Account> {
    /**
     *把结果集中的数据封装Account中，让后spring将每个Account加到list集合中
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setUname(resultSet.getString("uname"));
        account.setMoney(resultSet.getFloat("money"));
        return account;
    }
}
