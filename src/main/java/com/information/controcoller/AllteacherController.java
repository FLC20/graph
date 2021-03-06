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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@Controller
@RequestMapping("/allteacher")
public class AllteacherController {
    @Autowired
    private AllteachersService allteachersService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private LinksService linksService;
    @Autowired
    private MajorService majorService;
    @Autowired
    private SchoolsService schoolsService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private CommonService commonService;


    public static String getName(HttpSession session)throws IOException {
        Users userlogin = (Users)session.getAttribute("userlogin");
        System.out.println("username:"+userlogin.getUsername());

        return userlogin.getUsername();
    }
    @RequestMapping("/teacherinfo")
    public String teacherinfo(HttpSession httpSession, Model model) throws IOException {

        String teachername= getName(httpSession);
        Users users = usersService.selectTnumByTname(teachername);
        String teachernum=users.getUsernum();
        ArrayList<Allteachers> allteachers=allteachersService.selectTeacherByNum(teachernum);
        model.addAttribute("allteacher",allteachers);
        return "/teachers/teachersinfo";

    }
    @RequestMapping("/teacherupdate")
    public String toupdateteacher(HttpSession httpSession,Model model) throws IOException{
        String teachername= getName(httpSession);
        Users users = usersService.selectTnumByTname(teachername);
        String teachernum=users.getUsernum();
        Allteachers teachers=allteachersService.selectTeacherNameByNum(teachernum);
        model.addAttribute("teachers",teachers);
        return "/teachers/teacherupdate";
    }
    @RequestMapping("/update")
    public  @ResponseBody String teacherupdate(HttpSession httpSession,
                                               String teName,String school,String teNum,
                                               String teTitle, String department,String teTelephone,
                                               String email,String postcode,String teIdentity,
                                               String major,String awards, String achievements)throws IOException {
        JsonResult jsonResult=new JsonResult();
        String teachername= getName(httpSession);
        Users users = usersService.selectTnumByTname(teachername);
        String teachernum=users.getUsernum();
        Allteachers teachers=allteachersService.selectTeacherNameByNum(teachernum);
        String teid=teachers.getTeid();

        Allteachers teacher=new Allteachers(teid, teName, school, teNum, teTitle, department,
                            teTelephone, email, postcode, teIdentity, major, awards, achievements);
        AllteachersWithBLOBs teacherblobs=new AllteachersWithBLOBs(teid, teName, school, teNum, teTitle, department,
                teTelephone, email, postcode, teIdentity, major, awards, achievements);
        int backValue=allteachersService.updateteacher(teacher);
        allteachersService.updateteacher2(teacherblobs);
        if(backValue>0){
            if(department.length()>1) {
                Department department1 = departmentService.selectByName(department);
                String deid = department1.getDeid();
                System.out.println("department"+linksService.selectByIDandVal(teid, "??????"));
                if(linksService.selectByIDandVal(teid, "??????")==null) {
                    linksService.addlink(teid,deid,"??????");
                }
                else {
                    Links links = linksService.selectByIDandVal(teid, "??????");
                    int idd = links.getId();
                    linksService.updatelinkByID(idd, teid, deid);
                }
            }
            else {
                if(linksService.selectByIDandVal(teid, "??????")!=null)
                    linksService.delLinkByUidAndVal(teid,"??????");
            }
            if(major.length()>1) {
                Major major1 = majorService.selectByName(major);
                String maid = major1.getMaid();
                System.out.println("major"+linksService.selectByIDandVal(teid, "????????????"));
                if(linksService.selectByIDandVal(teid, "????????????")==null){
                    linksService.addlink(teid,maid,"????????????");
                }
                else{
                    Links links1 = linksService.selectByIDandVal(teid, "????????????");
                    int idm = links1.getId();
                    linksService.updatelinkByID(idm, teid, maid);
                }
            }
            else {
                if(linksService.selectByIDandVal(teid, "????????????")!=null)
                    linksService.delLinkByUidAndVal(teid,"????????????");
            }
            if(school.length()>1) {
                Schools schools = schoolsService.selectByName(school);
                String scid = schools.getScid();
                System.out.println("school"+linksService.selectByIDandVal(teid, "????????????"));
                if(linksService.selectByIDandVal(teid, "????????????")==null) {
                    linksService.addlink(teid,scid,"????????????");
                }
                else {
                    Links links2 = linksService.selectByIDandVal(teid, "????????????");
                    int ids = links2.getId();
                    linksService.updatelinkByID(ids, teid, scid);
                }
            }
            else {
                if(linksService.selectByIDandVal(teid, "????????????")!=null)
                    linksService.delLinkByUidAndVal(teid,"????????????");
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
        return new ResponseEntity<>(commonService.exportPdf1(getName(session)), headers, HttpStatus.OK);
    }
}
