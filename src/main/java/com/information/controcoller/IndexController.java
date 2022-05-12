package com.information.controcoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/login")
    public String login() {
        return "ulogin/studentlogin";
    }
    @RequestMapping("/teacherlogin")
    public String teacherlogin() {
        return "/ulogin/teacherlogin";
    }
    @RequestMapping("/studentlogin")
    public String studentlogin() {
        return "/ulogin/studentlogin";
    }
    @RequestMapping("/adminlogin")
    public String adminlogin() {
        return "/ulogin/adminlogin";
    }
    @RequestMapping("/loginfailed")
    public String loginfailed(){return "/loginfailed";}
    @RequestMapping("/404")
    public String failed(){return "/404";}

    @RequestMapping("/teachersinfo")
    public String teachersinfo(){return "/teachers/teachersinfo";}
    @RequestMapping("/teacherupdate")
    public String teacherupdate(){return "/teachers/teacherupdate";}
    @RequestMapping("/graph")
    public String graph(){return "/teachers/graph";}
    @RequestMapping("/graphinfo")
    public String graphinfo(){return "/teachers/graphinfo";}
    @RequestMapping("/graphinfo2")
    public String graphinfo2(){return "/teachers/graphinfo2";}

    @RequestMapping("/studentsinfo")
    public String studentsinfo(){return "/students/studentsinfo";}
    @RequestMapping("/studentupdate")
    public String studentupdate(){return "/students/studentupdate";}
    @RequestMapping("/graphs")
    public String graphs(){return "/students/graphs";}
    @RequestMapping("/graphinfos")
    public String graphinfos(){return "/students/graphinfos";}
    @RequestMapping("/graphinfo2s")
    public String graphinfo2s(){return "/students/graphinfo2s";}

    @RequestMapping("/repassword")
    public String repassword(){return "/repassword";}
    @RequestMapping("/adminindex")
    public String adminindex(){return "/admins/adminindex";}
    @RequestMapping("/addStudent")
    public String addStu(){return "/admins/add/addStudent";}
    @RequestMapping("/addTeacher")
    public String addTe(){return "/admins/add/addTeacher";}
    @RequestMapping("/addCourse")
    public String addCo(){return "/admins/add/addCourse";}
    @RequestMapping("/addDepartment")
    public String addDe(){return "/admins/add/addDepartment";}
    @RequestMapping("/addMajor")
    public String addMa(){return "/admins/add/addMajor";}
    @RequestMapping("/addSchool")
    public String addSch(){return "/admins/add/addSchool";}
    @RequestMapping("/addPlace")
    public String addPl(){return "/admins/add/addPlace";}





}
