package com.bindData.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//自定义数据类型转换器，String转成日期，实现Converter接口
public class StringToDateConverter implements Converter<String, Date> {
    /**
     *
     * @param s   传入进来字符串的值
     * @return    返回目标类型
     */
    @Override
    public Date convert(String s) {
        if(s==null){
            throw new RuntimeException("请传入参数");
        }
        DateFormat df = new SimpleDateFormat("yyyyy-mm-dd");
        try {
            return df.parse(s);
        } catch (Exception e) {
            throw new RuntimeException("数据转换出现错误");
        }
    }
}
