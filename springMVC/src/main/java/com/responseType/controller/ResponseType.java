package com.responseType.controller;

import com.responseType.entity.User;
import com.responseType.utils.defineException.SystemException;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

//测试springMVC的返回值类型和响应类型
@Controller
@RequestMapping("/responseType")
public class ResponseType {
    /**
     * 响应返回值是string类型
     * @param model
     * @return
     */
    @RequestMapping("StringType")
    public String testString(Model model){
        System.out.println("testString执行了。。。。。。");
        //模拟从后台去到数据并封装到User类中
        User user = new User();
        user.setName("彬彬");
        user.setAge(26);
        user.setDate(new Date());
        model.addAttribute("user",user);
        return "success";
    }
    /**
     * 没有返回值void
     * 当没有返回值时，默认转发到testVoid
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println("testString执行了。。。。。。");
        //自己编写转发页面,转发不会进入视图解析器，路径不能简写
        //转发
        //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        //重定向
        //response.sendRedirect(request.getContextPath()+"/index.jsp");
        //响应中文乱码问题
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //直接响应
        response.getWriter().print("嗨！！！！");
        return;
    }
    /**
     * 用关键字转发和重定向
     * @return
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("执行testForwardOrRedirect。。。。。。。。");
        //转发
        //return "forward:/WEB-INF/pages/start/success.jsp";
        //重定向
        return "redirect:/index.jsp";
    }
    /**
     * ajax异步请求模拟
     */
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("进来了！！！！");
        System.out.println("请求体:"+user);
        //User user = new User();
        user.setName("老祁");
        user.setAge(25);
        //做响应,返回user对象，自动转换成json
        return user;
    }
    /**
     *文件上传(传统方式)
     * 前提：将表单的enctype属性设为multipart/form-data,默认application/x-www-form-urlencode
     * 请求方式必须是post
     * 文件选择域<input type="file"/>
     */
    @RequestMapping("/testUpLoadFile1")
    public String  upLoadFile(HttpServletRequest request) throws Exception{
        System.out.println("文件上传开始了。。。。");
        //使用fileupload组件实现文件的上传
        //上传文件位置
        //String path = request.getSession().getServletContext().getRealPath("/uploads/");
        String path = "E:\\test";
        //判断该路径是否存在
        File file = new File(path);
        if (!file.exists()){//如果文件不存在，则创建对象
            //创建创建文件夹
            file.mkdirs();
        }
        System.out.println("path"+path);
        //解析request对象，获取文件项
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        //解析request
        List<FileItem> fileItems = servletFileUpload.parseRequest(request);//返回文件项的集合
        //遍历文件项
        for (FileItem fileItem:fileItems){
            //判断当前fileItem是否是文件上传项
            if (fileItem.isFormField()){
                //是普通表单项
            }else{
                //是文件上传项
                //获取上传文件的名称
                String fileName = fileItem.getName();

                //将文件名称设为唯一值(当文件名一致不会不会被覆盖)
                String uuid = UUID.randomUUID().toString().replace("-","");
                fileName = uuid+"_"+fileName;
                //完成文件上传
                fileItem.write(new File(path,fileName));
                //删除临时文件
                fileItem.delete();
            }
        }
        return "success";
    }

    /**
     *文件上传(MVC方式)
     * 前提：将表单的enctype属性设为multipart/form-data,默认application/x-www-form-urlencode
     * 请求方式必须是post
     * 文件选择域<input type="file"/>
     */
    @RequestMapping("/testUpLoadFile2")
    //MultipartFile对象名称必须和表单file域name属性值一致
    public String testUpLoadFile2(HttpServletRequest request, MultipartFile upLoad) throws Exception{
        System.out.println("文件上传开始了。。。。");
        //使用fileUpload组件实现文件的上传
        //上传文件位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //String path = "E:\\test";
        //判断该路径是否存在
        File file = new File(path);
        if (!file.exists()){//如果文件不存在，则创建对象
            //创建创建文件夹
            file.mkdirs();
        }
        //获取上传文件的名称
        //String fileName = fileItem.getName();
        String fileName = upLoad.getName();

        //将文件名称设为唯一值(当文件名一致不会不会被覆盖)
        String uuid = UUID.randomUUID().toString().replace("-","");
        fileName = uuid+"_"+fileName;
        //完成文件上传
        //fileItem.write(new File(path,fileName));
        upLoad.transferTo(new File(path,fileName));
        return "success";
    }
    /**
     * 测试异常界面
     * @return
     */
    @RequestMapping("/testException")
    public String testException()throws Exception{
        System.out.println("testException执行了。。。。。。");
        try {
            int i = 10/0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SystemException("出现错误");
        }
        return "success";
    }

    /**
     * 测试拦截器
     * @return
     */
    @RequestMapping("/testIntercepter")
    public ModelAndView testIntercepter(){
        System.out.println("testIntercepter执行了");
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        user.setName("binbin");
        user.setAge(18);
        List<User> users = new ArrayList<User>();
        users.add(user);
        modelAndView.addObject("src",users);
        modelAndView.setViewName("success");
        return modelAndView;
    }

}
