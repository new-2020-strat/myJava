package com.start.defineMybatis.cfg;

/**
 * 用于封装执行的sql语句和返回类型的全限定类名
 */
public class Mapper {
    private String querySql;//sql语句
    private String resultType;//实体类的全限定类名

    public String getQuerySql() {
        return querySql;
    }

    public void setQuerySql(String querySql) {
        this.querySql = querySql;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
