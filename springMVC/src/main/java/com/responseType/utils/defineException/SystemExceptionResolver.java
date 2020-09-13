package com.responseType.utils.defineException;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//自定义异常处理器
public class SystemExceptionResolver implements HandlerExceptionResolver {
    /**
     * 处理异常业务逻辑
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //处理异常对象
        SystemException systemException = null;
        if (e instanceof SystemException){
            systemException= (SystemException) e;
        }else {
            systemException = new SystemException("系统正在维护");
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error",systemException);
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
