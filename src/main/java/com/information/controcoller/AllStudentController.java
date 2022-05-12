package com.information.controcoller;

import com.information.entity.*;
import com.information.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@Controller
@RequestMapping("/allstudent")
public class AllStudentController {
    @Autowired
    private AllstudentsService allstudentsService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private LinksService linksService;
    @Autowired
    private MajorService majorService;
    @Autowired
    private SchoolsService schoolsService;
    @Autowired
    private PlaceService placeService;

    public static String getName(HttpSession session)throws IOException {
        Users userlogin = (Users)session.getAttribute("userlogin");
        System.out.println("username:"+userlogin.getUsername());

        return userlogin.getUsername();
    }

    @RequestMapping("/studentinfo")
    public String studentinfo(HttpSession httpSession, Model model) throws IOException{
        String studentname = getName(httpSession);
        Users users = usersService.selectTnumByTname(studentname);
        String studentnum = users.getUsernum();
        ArrayList<Allstudents> allstudents=allstudentsService.selectStudentByNum(studentnum);
        model.addAttribute("allstudent",allstudents);
        return "/students/studentsinfo";
    }

    @RequestMapping("/studentupdate")
    public String toupdatestudent(HttpSession httpSession,Model model) throws IOException{
        String studentname = getName(httpSession);
        Users users = usersService.selectTnumByTname(studentname);
        String studentnum = users.getUsernum();
        Allstudents allstudents=allstudentsService.selectStudentNameByNum(studentnum);
        model.addAttribute("students",allstudents);
        return "/students/studentupdate";
    }
    @RequestMapping("/update")
    public @ResponseBody String studentupdate(HttpSession httpSession,
                                              String stuname, String stunum,
                                              String sex, String  age, String nation,
                                              String political, String telephone, String lauguageAbility,
                                              String major, String place, String school)throws IOException{
        JsonResult jsonResult=new JsonResult();
        String studentname = getName(httpSession);
        Users users = usersService.selectTnumByTname(studentname);
        String studentnum = users.getUsernum();
        Allstudents allstudents=allstudentsService.selectStudentNameByNum(studentnum);
        String stid=allstudents.getStid();

        String id;
        id=stid;
        Allstudents student=new Allstudents(stid, id, stuname, stunum, sex, age, nation, political, telephone, lauguageAbility, major, place, school);

        int backValue=allstudentsService.updatestudent(student);
        if(backValue>0){
            if(major.length()>1) {
                Major major1 = majorService.selectByName(major);
                String maid = major1.getMaid();
                if(linksService.selectByIDandVal(stid,"专业")!=null) {
                    Links links1 = linksService.selectByIDandVal(stid, "专业");
                    int idm = links1.getId();
                    linksService.updatelinkByID(idm, stid, maid);
                }
                else {
                    linksService.addlink(stid,maid,"专业");
                }
            }
            else {
                if(linksService.selectByIDandVal(stid,"专业")!=null)
                    linksService.delLinkByUidAndVal(stid,"专业");
            }
            if(school.length()>1) {
                Schools schools = schoolsService.selectByName(school);
                String scid = schools.getScid();
                if(linksService.selectByIDandVal(stid,"学习生活")!=null) {
                    Links links2 = linksService.selectByIDandVal(stid, "学习生活");
                    int ids = links2.getId();
                    linksService.updatelinkByID(ids, stid, scid);
                }
                else {
                    linksService.addlink(stid,scid,"学习生活");
                }
            }
            else {
                if(linksService.selectByIDandVal(stid,"学习生活")!=null)
                    linksService.delLinkByUidAndVal(stid,"学习生活");
            }
            if(place.length()>1) {
                Place place1 = placeService.selectByName(place);
                String plid = place1.getPlid();
                if(linksService.selectByIDandVal(stid,"籍贯")!=null) {
                    Links links = linksService.selectByIDandVal(stid, "籍贯");
                    int idp = links.getId();
                    linksService.updatelinkByID(idp, stid, plid);
                }
                else {
                    linksService.addlink(stid,plid,"籍贯");
                }
            }
            else {
                if(linksService.selectByIDandVal(stid,"籍贯")!=null)
                    linksService.delLinkByUidAndVal(stid,"籍贯");
            }
            jsonResult.setResult(true);
        }
        else {
            jsonResult.setResult(false);jsonResult.setErrMsg("更新失败");
        }

        return jsonResult.toString();
    }

}
