package com.responseType.utils.intercepter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//自定义拦截器
public class TestIntercepter22 implements HandlerInterceptor {
    /**
     * 预处理，controller执行之前拦截
     * @param request
     * @param response
     * @param handler
     * @return 返回true放行到下一个拦截器或者controller中的方法，false不放行
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器执行了执行了22。。。。。");
        //request.getRequestDispatcher("").forward(request,response);
        return true;
    }

    /**
     * 后处理，执行完controller之后执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("后拦截器执行了执行了22。。。。。");
    }

    /**
     * 响应完前端页面后执行
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("响应后拦截器执行了执行了22。。。。。");
    }
}
