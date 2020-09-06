package com.anno.dao;

import com.anno.entity.Account;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Select;
@CacheNamespace(blocking = true)//开启二级缓存
public interface IAccountDao {
    /**
     * 通过id查询账户
     */
    @Select("select * from account where uid=#{uid}")
    Account findAccountById(Integer uid);
}
