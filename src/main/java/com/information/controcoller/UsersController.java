package com.information.controcoller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.information.entity.Page;
import com.information.entity.Users;
import com.information.service.AllteachersService;
import com.information.service.UsersService;
import com.information.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@Controller
@RequestMapping("/userlogin")
public class UsersController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private AllteachersService allteachersService;

    //login
    @RequestMapping(value = "/login",method = {RequestMethod.POST})
    public void adminlogin(@RequestParam(required = true) String username,
                           @RequestParam(required = true) String userpwd,
                           HttpSession session,
                           HttpServletResponse response) throws IOException {
        System.out.println(username+userpwd);
        Users userlogin = usersService.getUser(username,userpwd);
        if(userlogin!=null){
            session.setAttribute("userlogin",userlogin);
            Cookie cookie=new Cookie("username",String.valueOf(userlogin.getUsername()));
            Cookie cookie2=new Cookie("userpwd",userlogin.getPassword());
            System.out.println("here");
            cookie.setMaxAge(120);
            cookie2.setMaxAge(120);

            response.addCookie(cookie);
            response.addCookie(cookie2);
            if(userlogin.getType()==1){
                response.sendRedirect("/allstudent/studentinfo");
            }
            else if(userlogin.getType()==2){
                response.sendRedirect("/allteacher/teacherinfo");
            }
            else if(userlogin.getType()==3){
                response.sendRedirect("/graph/showadmin");
            }
            else {
                System.out.println("未查到匹配数据");
                response.sendRedirect("/login");
            }
        }
        else {
            System.out.println("未查到匹配数据");
            response.sendRedirect("/login");
        }
    }

    @RequestMapping("/allusers")
    public String Allusers(Model model,
                           @RequestParam(defaultValue = "1") Integer page,
                           @RequestParam(defaultValue = "15") Integer limit){
        PageHelper.startPage(page, limit);  //page：页数，limit:每页的信息数
        Page<Users> pages = new Page<Users>(page, limit);
        ArrayList<Users> users = usersService.getByPage(pages); //调用业务层查询方法
        PageInfo<Users> pageInfo = new PageInfo<>(users); //得到分页结果对象

        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("pages",pages);
        model.addAttribute("users",users);
        return "/admins/usermng";
    }
    @RequestMapping("/alluser")
    public String Alluser(Model model,
                           @RequestParam(defaultValue = "1") Integer page,
                           @RequestParam(defaultValue = "15") Integer limit){
        PageHelper.startPage(page, limit);  //page：页数，limit:每页的信息数
        Page<Users> pages = new Page<Users>(page, limit);
        ArrayList<Users> users = usersService.getByPage(pages); //调用业务层查询方法
        PageInfo<Users> pageInfo = new PageInfo<>(users); //得到分页结果对象

        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("pages",pages);
        model.addAttribute("userlogins",users);
        return "/admins/userrepass";
    }
    @RequestMapping("/toUpdate")
    public String update(Model model,String username){
        Users users=usersService.selectTnumByTname(username);
        String password;
        if(users.getType()==1){
        password="qwer1234";
        }
        else if(users.getType()==2){
            password="qwerasdf";
        }
        else {
            password="admin";
        }
        boolean backValue=usersService.updateuser(username,password);
        System.out.println(backValue);
        if(backValue){
            model.addAttribute("title","重置成功");
        }
        else {
            model.addAttribute("title","重置失败");
        }
        return "/admins/repass";
    }
    //全部重置
    @RequestMapping("/repassall")
    public String repassall(Model model){
        ArrayList<Users> users=usersService.selectAll();
        String password = null;
        String username = null;
        boolean backValue = false;
        for (Users user : users) {
            username=user.getUsername();
            if (user.getType() == 1) {
                password = "qwer1234";
            } else if (user.getType() == 2) {
                password = "qwerasdf";
            } else {
                password = "admin";
            }
//            System.out.println(user.getType()+password);
            backValue=usersService.updateuser(username,password);
        }
        System.out.println(backValue);
        if(backValue){
            model.addAttribute("title","重置成功");
        }
        else {
            model.addAttribute("title","重置失败");
        }
        return "/admins/repass";
    }



    //getuser
    @RequestMapping("/getuser")
    public String getuser(Model model,String username){

        Users users=usersService.selectTnumByTname(username);
        if(users!=null) {
            model.addAttribute("user", users);
            return "/admins/userget";
        }
        else {
            return "404";
        }
    }
    @RequestMapping("/getuser2")
    public String getuser2(Model model,String username){

        Users users=usersService.selectTnumByTname(username);
        if(users!=null) {
            model.addAttribute("userlogins", users);
            return "/admins/userget2";
        }
        else {
            return "404";
        }
    }
    @RequestMapping("/getUserName")
    public void getUserName(HttpSession session,HttpServletResponse response) throws IOException {
        JSONObject object= new JSONObject();
        Users userlogin = (Users)session.getAttribute("userlogin");
//        Allteachers allteachers=allteachersService.selectTeacherNameByNum(userlogin.getUsername());
        object.put("Username",userlogin.getUsername());
        System.out.println(object.toString());  //调用toString方法将json对象转换成json字符串
        response.getWriter().write(object.toString());
    }
    public String getName(HttpSession session)throws IOException {
        Users userlogin = (Users)session.getAttribute("userlogin");
        return userlogin.getUsername();
    }
    @RequestMapping(value = "/isLogin")
    @ResponseBody
    public Boolean isLogin(HttpSession session,HttpServletResponse response)throws IOException{

        Boolean result=(Boolean) session.getAttribute("result");
        return result;
    }
    @RequestMapping("/logout")
    public void logOut(HttpSession session, HttpServletResponse response)throws IOException {
        session.invalidate();
        response.sendRedirect("/login");
    }
    @RequestMapping(value = "/reset",method = {RequestMethod.POST})
    public void reset(
            @RequestParam(required = true) String userpwd,
            HttpSession session,
            HttpServletResponse response)throws IOException{
        String username;
        username=getName(session);
//        String password=usersService.selectTnumByTname(username).getPassword();

        boolean result=usersService.updateuser(username,userpwd);
        session.setAttribute("result",result);

        if(userpwd.length()<=0){
            System.out.println("修改失败");
            System.out.println("1"+userpwd);
            response.sendRedirect("/repassword");
        }
        else {
            if (result) {
                System.out.println("修改成功！");
                session.invalidate();
                response.sendRedirect("/login");
            } else {
                //注册不成功,返回注册页面
                System.out.println("修改失败");
                response.sendRedirect("/repassword");
            }
        }
    }
}
