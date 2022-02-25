package com.nowcoder.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @author fff
 * @create 2022-2-20 11:45
 */
@Controller
@RequestMapping("/alpha")
public class AlphaController {
  /*  @Autowired
    private AlphaService alphaService;
    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "hello spring boot";
    }
    @RequestMapping("/find")
    @ResponseBody
    public String getData(){
        return alphaService.find();
    }*/
    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取请求数据
        System.out.println(request.getMethod());
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            String val = request.getHeader(name);
            System.out.println(name+" "+val);
        }
        String code = request.getParameter("code");
        System.out.println(code);
        //向浏览器响应数据
        response.setContentType("text/html charaset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write("<h1>abc<h1>");
        writer.close();

    }
    //以参数的形式传递，
    @RequestMapping(path="/student",method = RequestMethod.GET)
    @ResponseBody
    public String getstudent(@RequestParam(name = "cur", required = false,defaultValue = "2") int cur,
                          @RequestParam(name = "limit") int limit){
        System.out.println("cur:"+cur+"    limit:"+limit);
        return "a studnet";
    }
    //student/123的方式传递
    @RequestMapping(path="/student/{id}")
    @ResponseBody
    public String GetStudent (@PathVariable("id") int id){
        System.out.println(id);
        return "id - studnet";

    }
    //获取post请求的数据
    @RequestMapping(path = "/addstudent",method = RequestMethod.POST)
    @ResponseBody
    public String add(String name,int age){
        System.out.println(age);
        System.out.println(name);
        return "success";
    }
    //响应一个动态html
    @RequestMapping(path="/teacher",method = RequestMethod.GET)
    public ModelAndView getTeacher(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","frank");
        modelAndView.addObject("age","32");
        modelAndView.setViewName("/demo/view");
        return modelAndView;
    }
}
