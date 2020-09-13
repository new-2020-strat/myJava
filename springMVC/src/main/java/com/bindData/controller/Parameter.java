package com.bindData.controller;

import com.bindData.entity.Acount;
import com.bindData.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

/**
 * 测试数据的绑定
 */
@Controller
@RequestMapping("/bindData")
@SessionAttributes(value = "userName")//将userName=binbin也存入session域中
public class Parameter {
    /**
     * 请求参数的绑定
     * @return
     * 当请求的url中的key与方法的参数名称一样时会自动绑定
     */
    @RequestMapping("/basicType")
    public String params(String uname){
        System.out.println("获取到用户："+uname);
        return "hello";
    }
    /**
     * 将数据绑定到Javabean中
     * @return
     */
    @RequestMapping("/saveAccount")
    public String saveAccount(Acount account){
        System.out.println("表单信息："+account);
        return "hello";
    }
    /**
     * 绑定到基本javabean类Account引用User的实体类中
     * @return
     */
    @RequestMapping("/saveAccountWithUser")
    public String saveAccount1(Acount account){
        System.out.println("表单信息："+account);
        return "hello";
    }
    /**
     * 将数据绑定到list和map的封装中
     * @return
     */
    @RequestMapping("/saveAccountListAndMap")
    public String saveAccountListAndMap(Acount account){
        System.out.println("表单信息："+account);
        return "hello";
    }
    /**
     * 自定义类型转换器(装换Date类)
     * 在springmvc.xml配置文件中配置注册
     * @return
     */
    @RequestMapping("/saveUser")
    public String saveUser(User user){
        System.out.println("表单信息："+user);
        return "hello";
    }
    /**
     * 获取原生态api
     * 想要原生态servlet的那个对象就在对方法参数中写那个对象
     * @return
     */
    @RequestMapping("/getOriginServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response){
        System.out.println("request:"+request);
        HttpSession session = request.getSession();
        System.out.println("session:"+session);
        ServletContext context = session.getServletContext();
        System.out.println("context:"+context);
        System.out.println("response:"+response);
        return "hello";
    }
    /**
     * 获取请求头
     * @param header
     * @return
     */
    @RequestMapping("/getRequestHeader")
    //@RequestBody:获取前台的请求体
    public String getRequesHeader(@RequestHeader(value = "Accept") String header){
        System.out.println("RequestHeader=="+header);
        return "hello";
    }
    /**
     * 获取请求体
     * @param body
     * @return
     */
    @RequestMapping("/getRequestBody")
    //@RequestBody:获取前台的请求体
    public String getRequestBody(@RequestBody String body){
        System.out.println("RequestBody=="+body);
        return "hello";
    }
    /**
     * 处理前台请求参数属性和后台属性名不一致
     * RequestParam:修饰参数，指定前台数据的key值
     * @param username
     * @return
     */
    @RequestMapping("/requestParameterDifferent")
    public String requestParameterDifferent(@RequestParam(name = "uname") String username){
        System.out.println("username=="+username);
        return "hello";
    }


    /**
     * @PathVariable
     * rest编程风格，当请求路径一样时根据不同的请求方式访问，便于缓存管理
     * 也可以用{id}占位符来区分请求执行哪个方法
     */
    @RequestMapping("/restProgramType/{uid}")
    public String testPathVariable(@PathVariable(name = "uid") String id){
        System.out.println("id="+id);
        return "hello";
    }
    /**
     * 获取cookie
     * @param cookieValue
     * @return
     */
    @RequestMapping("/getCookie")
    public String getCookie(@CookieValue(value = "JSESSIONID") String cookieValue){
        System.out.println("cookieValue=="+cookieValue);
        return "hello";
    }

    /**
     * ModelAttribute注解可以修饰方法和参数
     * 修饰方法表示该方法在控制器的方法执行之前先执行
     * 第一种写法(有返回值)
     */
    /*@RequestMapping("/testModelModelAttribute")
    public String testModelAttribute(User user){
        System.out.println("ModelAtrribute执行了！！！！！！");
        System.out.println("user="+user);
        return "hello";
    }
   @ModelAttribute//该方法先执行就可以先做一些操作
    public User showUser(String name){
        System.out.println("showUser执行了！！！！！！");
        User user = new User();
        user.setName(name);
        user.setAge(16);
        user.setDate(new Date());
        return user;
    }*/

    /**
     * 第二种写法(没有返回值)
     * @param user
     * @return
     */
    @RequestMapping("/testModelModelAttribute")
    public String testModelAttribute(@ModelAttribute("user") User user){
        System.out.println("ModelAtrribute执行了！！！！！！");
        System.out.println("user="+user);
        return "hello";
    }
    @ModelAttribute//该方法先执行就可以先做一些操作
    public void showUser(String name, Map<String,User> map){
        System.out.println("showUser执行了！！！！！！");
        User user = new User();
        user.setName(name);
        user.setAge(16);
        user.setDate(new Date());
       map.put("user",user);
    }
    @RequestMapping("/testSessionAttribute")
    public String testSessionAtrribute(Model model){
        System.out.println("testSessionAttribute执行了！！！！！！");
        model.addAttribute("userName","binbin");//将userName=binbin 键值对存到request中
        return "hello";
    }
    @RequestMapping("/getSession")
    public String  getSession(ModelMap modelMap){
        System.out.println("getSession执行了！！！！！！");
        //从session域中中取值
        String name = (String )modelMap.get("userName");
        System.out.println("userName=="+name);
        return "hello";
    }
    @RequestMapping("/deleteSession")
    public String  deleteSession(SessionStatus sessionStatus){
        System.out.println("deleteSession执行了！！！！！！");
        //从session域中删除
        sessionStatus.setComplete();
        return "hello";
    }
}
