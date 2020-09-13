package com.responseType.utils.defineException;
//自定义异常类
public class SystemException extends Exception{
    private String message;

    public SystemException(String message) {
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
