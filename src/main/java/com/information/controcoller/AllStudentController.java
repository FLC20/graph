package com.information.controcoller;

import cn.hutool.core.date.DateUtil;
import com.information.entity.*;
import com.information.service.*;
import io.swagger.annotations.ApiOperation;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

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
    @Autowired
    private CommonService commonService;

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
                if(linksService.selectByIDandVal(stid,"??????")!=null) {
                    Links links1 = linksService.selectByIDandVal(stid, "??????");
                    int idm = links1.getId();
                    linksService.updatelinkByID(idm, stid, maid);
                }
                else {
                    linksService.addlink(stid,maid,"??????");
                }
            }
            else {
                if(linksService.selectByIDandVal(stid,"??????")!=null)
                    linksService.delLinkByUidAndVal(stid,"??????");
            }
            if(school.length()>1) {
                Schools schools = schoolsService.selectByName(school);
                String scid = schools.getScid();
                if(linksService.selectByIDandVal(stid,"????????????")!=null) {
                    Links links2 = linksService.selectByIDandVal(stid, "????????????");
                    int ids = links2.getId();
                    linksService.updatelinkByID(ids, stid, scid);
                }
                else {
                    linksService.addlink(stid,scid,"????????????");
                }
            }
            else {
                if(linksService.selectByIDandVal(stid,"????????????")!=null)
                    linksService.delLinkByUidAndVal(stid,"????????????");
            }
            if(place.length()>1) {
                Place place1 = placeService.selectByName(place);
                String plid = place1.getPlid();
                if(linksService.selectByIDandVal(stid,"??????")!=null) {
                    Links links = linksService.selectByIDandVal(stid, "??????");
                    int idp = links.getId();
                    linksService.updatelinkByID(idp, stid, plid);
                }
                else {
                    linksService.addlink(stid,plid,"??????");
                }
            }
            else {
                if(linksService.selectByIDandVal(stid,"??????")!=null)
                    linksService.delLinkByUidAndVal(stid,"??????");
            }
            jsonResult.setResult(true);
        }
        else {
            jsonResult.setResult(false);jsonResult.setErrMsg("????????????");
        }

        return jsonResult.toString();
    }
    @GetMapping(value = "/pdf", produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiOperation(value = "PDF ????????????", notes = "PDF ????????????")
    public ResponseEntity<byte[]> exportPdf2(HttpSession session) throws IOException, JRException {
        String fileName = "contract" + DateUtil.format(new Date(), "yyyy-MM-dd") + ".pdf";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<>(commonService.exportPdf2(getName(session)), headers, HttpStatus.OK);
    }


}
