package com.aop.aop.anno.service;

/**
 * 模拟业务层接口
 */
public interface IAccountService {
    void saveAccount();
    void updateAccount(int i);
    int deleteAccount();
}
