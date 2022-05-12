package com.information.controcoller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.information.entity.*;
import com.information.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AllnodesService allnodesService;
    @Autowired
    private NodesService nodesService;
    @Autowired
    private LinksService linksService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private AllteachersService allteachersService;
    @Autowired
    private AllstudentsService allstudentsService;

    @Autowired
    private MajorService majorService;
    @Autowired
    private SchoolsService schoolsService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private PlaceService placeService;
    @Autowired
    private CourseService courseService;

    @RequestMapping("/stlist")
    public String liststudent(Model model,@RequestParam(defaultValue = "1") Integer page,
                              @RequestParam(defaultValue = "15") Integer limit){
        PageHelper.startPage(page, limit);  //page：页数，limit:每页的信息数
        Page<Allstudents> pages = new Page<Allstudents>(page, limit);

        ArrayList<Allstudents> allstudents = allstudentsService.getPage(pages);//调用业务层查询方法
        PageInfo<Allstudents> pageInfo = new PageInfo<>(allstudents); //得到分页结果对象

        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("pages",pages);
        model.addAttribute("Students",allstudents);
        return "/admins/list/listStudent";

    }
    @RequestMapping("/telist")
    public String listteacher(Model model,@RequestParam(defaultValue = "1") Integer page,
                              @RequestParam(defaultValue = "15") Integer limit){
        PageHelper.startPage(page, limit);  //page：页数，limit:每页的信息数
        Page<Allteachers> pages = new Page<Allteachers>(page, limit);

        ArrayList<Allteachers> allteachers = allteachersService.getPage(pages);//调用业务层查询方法
        PageInfo<Allteachers> pageInfo = new PageInfo<>(allteachers); //得到分页结果对象

        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("pages",pages);
        model.addAttribute("Teachers",allteachers);
        return "/admins/list/listTeacher";

    }
    @RequestMapping("/colist")
    public String listcourse(Model model,@RequestParam(defaultValue = "1") Integer page,
                              @RequestParam(defaultValue = "15") Integer limit){
        PageHelper.startPage(page, limit);  //page：页数，limit:每页的信息数
        Page<Course> pages = new Page<Course>(page, limit);

        ArrayList<Course> courses = courseService.getPage(pages);//调用业务层查询方法
        PageInfo<Course> pageInfo = new PageInfo<>(courses); //得到分页结果对象

        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("pages",pages);
        model.addAttribute("Courses",courses);
        return "/admins/list/listCourse";

    }
    @RequestMapping("/delist")
    public String listdepartment(Model model,@RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "15") Integer limit){
        PageHelper.startPage(page, limit);  //page：页数，limit:每页的信息数
        Page<Department> pages = new Page<Department>(page, limit);

        ArrayList<Department> departments = departmentService.getPage(pages);//调用业务层查询方法
        PageInfo<Department> pageInfo = new PageInfo<>(departments); //得到分页结果对象

        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("pages",pages);
        model.addAttribute("Departments",departments);
        return "/admins/list/listDepartment";

    }
    @RequestMapping("/malist")
    public String malist(Model model,@RequestParam(defaultValue = "1") Integer page,
                                 @RequestParam(defaultValue = "15") Integer limit){
        PageHelper.startPage(page, limit);  //page：页数，limit:每页的信息数
        Page<Major> pages = new Page<Major>(page, limit);

        ArrayList<Major> majors = majorService.getPage(pages);//调用业务层查询方法
        PageInfo<Major> pageInfo = new PageInfo<>(majors); //得到分页结果对象

        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("pages",pages);
        model.addAttribute("Majors",majors);
        return "/admins/list/listMajor";

    }
    @RequestMapping("/pllist")
    public String pllist(Model model,@RequestParam(defaultValue = "1") Integer page,
                         @RequestParam(defaultValue = "15") Integer limit){
        PageHelper.startPage(page, limit);  //page：页数，limit:每页的信息数
        Page<Place> pages = new Page<Place>(page, limit);

        ArrayList<Place> places = placeService.getPage(pages);//调用业务层查询方法
        PageInfo<Place> pageInfo = new PageInfo<>(places); //得到分页结果对象

        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("pages",pages);
        model.addAttribute("Places",places);
        return "/admins/list/listPlace";

    }
    @RequestMapping("/sclist")
    public String sclist(Model model,@RequestParam(defaultValue = "1") Integer page,
                         @RequestParam(defaultValue = "15") Integer limit){
        PageHelper.startPage(page, limit);  //page：页数，limit:每页的信息数
        Page<Schools> pages = new Page<Schools>(page, limit);

        ArrayList<Schools> schools =schoolsService.getPage(pages);//调用业务层查询方法
        PageInfo<Schools> pageInfo = new PageInfo<>(schools); //得到分页结果对象

        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("pages",pages);
        model.addAttribute("Schools",schools);
        return "/admins/list/listSchool";

    }


    @RequestMapping("/stadd")
    public @ResponseBody String addStudent(String id,String stid,String stuname, String stunum,
                                          String sex, String  age, String nation,
                                          String political, String telephone, String lauguageAbility,
                                          String major, String place, String school)throws IOException{
        JsonResult jsonResult=new JsonResult();
        if(allstudentsService.selectByID(stid)!=null){
            jsonResult.setResult(false);
            jsonResult.setErrMsg("添加失败，学生ID重复");
            return jsonResult.toString();
        }
        else{
            Allstudents student=new Allstudents(stid, id, stuname, stunum, sex, age, nation, political, telephone, lauguageAbility, major, place, school);
            int backValue=allstudentsService.insertStudent(student);
            String password;
            password="qwer1234";
            int type;
            type=1;
            usersService.insertUser(stid,stunum,password,school,stunum,type);
            String allnodeid=stid;
            String nodeid=stid;
            String uid=stid;
            String name=stuname;
            int symbolSize=3;
            int category=0;
            allnodesService.insertAllnodes(allnodeid,uid,name,symbolSize,category);
            nodesService.insertNodes(nodeid,name,symbolSize,category);
            if(backValue>0){
                if(major.length()>1) {
                    Major major1 = majorService.selectByName(major);
                    String maid = major1.getMaid();
                    linksService.addlink(stid, maid, "专业");
                }
                if(school.length()>1) {
                    Schools schools = schoolsService.selectByName(school);
                    String scid = schools.getScid();
                    linksService.addlink(stid, scid, "学习生活");
                }
                if(place.length()>1) {
                    Place place1 = placeService.selectByName(place);
                    String plid = place1.getPlid();
                    linksService.addlink(stid, plid, "籍贯");
                }
                jsonResult.setResult(true);
            }
            else {
                jsonResult.setResult(false);jsonResult.setErrMsg("添加失败");
            }

            return jsonResult.toString();
        }
    }

    @RequestMapping("/teadd")
    public @ResponseBody String addTeacher(String teid,String teName,String school,String teNum,
                                           String teTitle, String department,String teTelephone,
                                           String email,String postcode,String teIdentity,
                                           String major,String awards, String achievements)throws IOException{
        JsonResult jsonResult=new JsonResult();
        if(allteachersService.selectByID(teid)!=null){
            jsonResult.setResult(false);
            jsonResult.setErrMsg("添加失败，教师ID重复");
            return jsonResult.toString();
        }
        else{
//            Allteachers teacher=new Allteachers(teid, teName, school, teNum, teTitle, department,
//                    teTelephone, email, postcode, teIdentity, major, awards, achievements);
            AllteachersWithBLOBs teacherblobs=new AllteachersWithBLOBs(teid, teName, school, teNum, teTitle, department,
                    teTelephone, email, postcode, teIdentity, major, awards, achievements);
            int backValue=allteachersService.insertTeacher(teacherblobs);

            String password;
            password="qwerasdf";
            int type;
            type=2;
            usersService.insertUser(teid,teNum,password,school,teNum,type);
            String allnodeid=teid;
            String nodeid=teid;
            String uid=teid;
            String name=teName;
            int symbolSize=3;
            int category=0;
            allnodesService.insertAllnodes(allnodeid,uid,name,symbolSize,category);
            nodesService.insertNodes(nodeid,name,symbolSize,category);
            if(backValue>0){
                if(major.length()>1) {
                    Major major1 = majorService.selectByName(major);
                    String maid = major1.getMaid();
                    linksService.addlink(teid, maid, "所属专业");
                }
                if(school.length()>1) {
                    Schools schools = schoolsService.selectByName(school);
                    String scid = schools.getScid();
                    linksService.addlink(teid, scid, "教学生活");
                }
                if(department.length()>1) {
                    Department department1 = departmentService.selectByName(department);
                    String deid = department1.getDeid();
                    linksService.addlink(teid,deid,"部门");
                }
                jsonResult.setResult(true);
            }
            else {
                jsonResult.setResult(false);jsonResult.setErrMsg("添加失败");
            }

            return jsonResult.toString();
        }
    }
    @RequestMapping("/coadd")
    public @ResponseBody String coadd(String coid,String coname,String coscore)throws IOException {
        JsonResult jsonResult = new JsonResult();
        int symbolSize=9;
        int category=2;
        if (courseService.selectByName(coname) != null) {
            jsonResult.setResult(false);
            jsonResult.setErrMsg("添加失败，课程重复");
            return jsonResult.toString();
        } else {
            Course course = new Course(coid, coname, coscore);
            allnodesService.insertAllnodes(coid,coid,coname,symbolSize,category);
            nodesService.insertNodes(coid,coname,symbolSize,category);
            int backValue = courseService.insertCo(course);
            if (backValue > 0) {
                jsonResult.setResult(true);
            } else {
                jsonResult.setResult(false);
                jsonResult.setErrMsg("添加失败");
            }
            return jsonResult.toString();
        }
    }
    @RequestMapping("/deadd")
    public @ResponseBody String deadd(String deid,String dename,String defrom,
                                      String detime,String delevel,String deawards) throws IOException {
        JsonResult jsonResult = new JsonResult();
        int symbolSize=20;
        int category=3;
        if(departmentService.selectByName(dename)!=null){
            jsonResult.setResult(false);
            jsonResult.setErrMsg("添加失败，部门重复");
            return jsonResult.toString();
        } else {
            DepartmentWithBLOBs department = new DepartmentWithBLOBs(deid,dename,defrom,detime,delevel,deawards);
            allnodesService.insertAllnodes(deid,deid,dename,symbolSize,category);
            nodesService.insertNodes(deid,dename,symbolSize,category);
            int backValue = departmentService.insertDe(department);
            if (backValue > 0) {
                jsonResult.setResult(true);
            } else {
                jsonResult.setResult(false);
                jsonResult.setErrMsg("添加失败");
            }
            return jsonResult.toString();
        }
    }
    @RequestMapping("/maadd")
    public @ResponseBody String maadd(String maid,String majname) throws IOException {
        JsonResult jsonResult = new JsonResult();
        int symbolSize=15;
        int category=4;
        if(majorService.selectByName(majname)!=null){
            jsonResult.setResult(false);
            jsonResult.setErrMsg("添加失败，专业重复");
            return jsonResult.toString();
        } else {
            Major major = new Major(maid,maid,majname);
            allnodesService.insertAllnodes(maid,maid,majname,symbolSize,category);
            nodesService.insertNodes(maid,majname,symbolSize,category);
            int backValue = majorService.insetMa(major);
            if (backValue > 0) {
                jsonResult.setResult(true);
            } else {
                jsonResult.setResult(false);
                jsonResult.setErrMsg("添加失败");
            }
            return jsonResult.toString();
        }
    }
    @RequestMapping("/pladd")
    public @ResponseBody String pladd(String plid,String plname) throws IOException {
        JsonResult jsonResult = new JsonResult();
        int symbolSize=12;
        int category=5;
        if(placeService.selectByName(plname)!=null){
            jsonResult.setResult(false);
            jsonResult.setErrMsg("添加失败，地区重复");
            return jsonResult.toString();
        } else {
            Place place =new Place(plid,plid,plname);
            allnodesService.insertAllnodes(plid,plid,plname,symbolSize,category);
            nodesService.insertNodes(plid,plname,symbolSize,category);
            int backValue = placeService.insertPl(place);
            if (backValue > 0) {
                jsonResult.setResult(true);
            } else {
                jsonResult.setResult(false);
                jsonResult.setErrMsg("添加失败");
            }
            return jsonResult.toString();
        }
    }
    @RequestMapping("/scadd")
    public @ResponseBody String scadd(String scid,String scname,String scplace,
                                      String sctype,String sctime,String schoolMotto,
                                      String schoolSpirit,String teachingStyle,
                                      String styleOfStudy) throws IOException {
        JsonResult jsonResult = new JsonResult();
        int symbolSize=40;
        int category=6;
        if(schoolsService.selectByName(scname)!=null){
            jsonResult.setResult(false);
            jsonResult.setErrMsg("添加失败，学校重复");
            return jsonResult.toString();
        } else {
            Schools schools = new Schools(scid,scid,scname,scplace,sctype,sctime,
                                schoolMotto,schoolSpirit,teachingStyle,styleOfStudy);
            allnodesService.insertAllnodes(scid,scid,scname,symbolSize,category);
            nodesService.insertNodes(scid,scname,symbolSize,category);
            int backValue = schoolsService.insertSc(schools);
            if (backValue > 0) {
                jsonResult.setResult(true);
            } else {
                jsonResult.setResult(false);
                jsonResult.setErrMsg("添加失败");
            }
            return jsonResult.toString();
        }
    }


    @RequestMapping("/stup")
    public String toupdatestudent(Model model,String stid) throws IOException {
        Users users = usersService.selectByUid(stid);
        String studentnum = users.getUsernum();
        Allstudents allstudents=allstudentsService.selectStudentNameByNum(studentnum);
        model.addAttribute("students",allstudents);
        return "/admins/update/updateStudent";
    }
    @RequestMapping("/teup")
    public String toupdateteacher(Model model,String teid) throws IOException {
        Users users = usersService.selectByUid(teid);
        String teachernum = users.getUsernum();
        Allteachers allteachers=allteachersService.selectTeacherNameByNum(teachernum);
        model.addAttribute("teachers",allteachers);
        return "/admins/update/updateTeacher";
    }
    @RequestMapping("/coup")
    private String toupdatecourse(Model model,String coname) {
        Course course=courseService.selectByName(coname);
        model.addAttribute("courses",course);
        return "/admins/update/updateCourse";
    }
    @RequestMapping("/deup")
    private String toupdatede(Model model,String dename) {
        Department department=departmentService.selectByName(dename);
        model.addAttribute("departments",department);
        return "/admins/update/updateDepartment";
    }
    @RequestMapping("/scup")
    private String toupdatesc(Model model,String scname) {
        Schools schools=schoolsService.selectByName(scname);
        model.addAttribute("schools",schools);
        return "/admins/update/updateSchool";
    }





    @RequestMapping("/stupdate")
    public @ResponseBody String studentupdate(String stuname, String stunum,
                                              String sex, String  age, String nation,
                                              String political, String telephone, String lauguageAbility,
                                              String major, String place, String school)throws IOException{
        JsonResult jsonResult=new JsonResult();
        Allstudents allstudents=allstudentsService.selectStudentNameByNum(stunum);
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
    @RequestMapping("/teupdate")
    public  @ResponseBody String teacherupdate(String teName,String school,String teNum,
                                               String teTitle, String department,String teTelephone,
                                               String email,String postcode,String teIdentity,
                                               String major,String awards, String achievements)throws IOException {
        JsonResult jsonResult=new JsonResult();
        Allteachers teachers=allteachersService.selectTeacherNameByNum(teNum);
        String teid=teachers.getTeid();

        AllteachersWithBLOBs teacherblobs=new AllteachersWithBLOBs(teid, teName, school, teNum, teTitle, department,
                teTelephone, email, postcode, teIdentity, major, awards, achievements);

        allteachersService.updateteacher2(teacherblobs);
        System.out.println(department.length());
        if(department.length()>1) {
            Department department1 = departmentService.selectByName(department);
            String deid = department1.getDeid();
            System.out.println("department"+linksService.selectByIDandVal(teid, "部门"));
            if(linksService.selectByIDandVal(teid, "部门")==null) {
                linksService.addlink(teid,deid,"部门");
            }
            else {
                Links links = linksService.selectByIDandVal(teid, "部门");
                int idd = links.getId();
                linksService.updatelinkByID(idd, teid, deid);
            }
        }
        else {
            if(linksService.selectByIDandVal(teid, "部门")!=null)
            linksService.delLinkByUidAndVal(teid,"部门");
        }
        if(major.length()>1) {
            Major major1 = majorService.selectByName(major);
            String maid = major1.getMaid();
            System.out.println("major"+linksService.selectByIDandVal(teid, "所属专业"));
            if(linksService.selectByIDandVal(teid, "所属专业")==null){
                linksService.addlink(teid,maid,"所属专业");
            }
            else{
                Links links1 = linksService.selectByIDandVal(teid, "所属专业");
                int idm = links1.getId();
                linksService.updatelinkByID(idm, teid, maid);
            }
        }
        else {
            if(linksService.selectByIDandVal(teid, "所属专业")!=null)
            linksService.delLinkByUidAndVal(teid,"所属专业");
        }
        if(school.length()>1) {
            Schools schools = schoolsService.selectByName(school);
            String scid = schools.getScid();
            System.out.println("school"+linksService.selectByIDandVal(teid, "教学生活"));
            if(linksService.selectByIDandVal(teid, "教学生活")==null) {
                linksService.addlink(teid,scid,"教学生活");
            }
            else {
                Links links2 = linksService.selectByIDandVal(teid, "教学生活");
                int ids = links2.getId();
                linksService.updatelinkByID(ids, teid, scid);
            }
        }
        else {
            if(linksService.selectByIDandVal(teid, "教学生活")!=null)
            linksService.delLinkByUidAndVal(teid,"教学生活");
        }
            jsonResult.setResult(true);
        return jsonResult.toString();
    }
    @RequestMapping("/coupdate")
    public @ResponseBody String courseupdate(String coid,String coname,String coscore)throws IOException {
        JsonResult jsonResult = new JsonResult();
        Course course=new Course(coid,coname,coscore);
        int backValue=courseService.updateCourse(course);
        if(backValue>0){
            jsonResult.setResult(true);
        }
        else {
            jsonResult.setResult(false);jsonResult.setErrMsg("更新失败");
        }
        return jsonResult.toString();
    }
    @RequestMapping("/deupdate")
    public @ResponseBody String deupdate(String deid,String dename,String defrom,
                                         String detime,String delevel,String deawards)throws IOException {
        JsonResult jsonResult = new JsonResult();
        DepartmentWithBLOBs department=new DepartmentWithBLOBs(deid,dename,defrom,detime,delevel,deawards);
        int backValue=departmentService.updateDe(department);
        if(backValue>0){
            jsonResult.setResult(true);
        }
        else {
            jsonResult.setResult(false);jsonResult.setErrMsg("更新失败");
        }
        return jsonResult.toString();
    }
    @RequestMapping("/scupdate")
    public @ResponseBody String scupdate(String scid,String scname,String scplace,
                                         String sctype,String sctime,String schoolMotto,
                                         String schoolSpirit,String teachingStyle,
                                         String styleOfStudy)throws IOException {
        JsonResult jsonResult = new JsonResult();
        Schools schools = new Schools(scid,scid,scname,scplace,sctype,sctime,
                schoolMotto,schoolSpirit,teachingStyle,styleOfStudy);
        int backValue=schoolsService.updateSc(schools);
        if(backValue>0){
            jsonResult.setResult(true);
        }
        else {
            jsonResult.setResult(false);jsonResult.setErrMsg("更新失败");
        }
        return jsonResult.toString();
    }




    @RequestMapping("/stdel")
    public String stdel(Model model,String stid){
        Allstudents allstudents=allstudentsService.selectByUid(stid);
        String stnum=allstudents.getStunum();
        if(usersService.selectByUid(allstudents.getStid())!=null)
        usersService.delUserByName(stnum);
        if(linksService.selectLinByUID(allstudents.getStid()).size()>0)
        linksService.delLinkByUid(stid);
        if(allnodesService.selectByUID(allstudents.getStid())!=null)
            allnodesService.delAllnodes(stid);
        if(nodesService.selectByUID(allstudents.getStid())!=null)
            nodesService.delNodes(stid);
        allstudentsService.delstudentByUid(stid);
        model.addAttribute("title","删除成功");
        return "/admins/repass";
    }
    @RequestMapping("/tedel")
    public String tedel(Model model,String teid){
        Allteachers allteachers=allteachersService.selectByID(teid);
        String tenum=allteachers.getTeNum();
        if(usersService.selectByUid(allteachers.getTeid())!=null)
            usersService.delUserByName(tenum);
        if(linksService.selectLinByUID(allteachers.getTeid()).size()>0)
            linksService.delLinkByUid(teid);
        if(allnodesService.selectByUID(allteachers.getTeid())!=null)
            allnodesService.delAllnodes(teid);
        if(nodesService.selectByUID(allteachers.getTeid())!=null)
            nodesService.delNodes(teid);
        allteachersService.delteacherByUid(teid);
        model.addAttribute("title","删除成功");
        return "/admins/repass";
    }
    @RequestMapping("/codel")
    public String codel(Model model,String coid){
        allnodesService.delAllnodes(coid);
        nodesService.delNodes(coid);
        if(linksService.selectLinByUID(coid).size()>0)
            linksService.delLinkByUid(coid);
        courseService.delCourseByCoid(coid);
        model.addAttribute("title","删除成功");
        return "/admins/repass";
    }
    @RequestMapping("/dedel")
    public String dedel(Model model,String deid){
        departmentService.delDepByDeid(deid);
        allnodesService.delAllnodes(deid);
        nodesService.delNodes(deid);
        if(linksService.selectLinByUID(deid).size()>0)
            linksService.delLinkByUid(deid);
        model.addAttribute("title","删除成功");
        return "/admins/repass";
    }
    @RequestMapping("/madel")
    public String madel(Model model,String maid){
        majorService.delMaByMaid(maid);
        allnodesService.delAllnodes(maid);
        nodesService.delNodes(maid);
        if(linksService.selectLinByUID(maid).size()>0)
            linksService.delLinkByUid(maid);
        model.addAttribute("title","删除成功");
        return "/admins/repass";
    }
    @RequestMapping("/pldel")
    public String pldel(Model model,String plid){
        placeService.delPlByPlid(plid);
        allnodesService.delAllnodes(plid);
        nodesService.delNodes(plid);
        if(linksService.selectLinByUID(plid).size()>0)
            linksService.delLinkByUid(plid);
        model.addAttribute("title","删除成功");
        return "/admins/repass";
    }
    @RequestMapping("/scdel")
    public String scdel(Model model,String scid){
        schoolsService.delScByScid(scid);
        allnodesService.delAllnodes(scid);
        nodesService.delNodes(scid);
        if(linksService.selectLinByUID(scid).size()>0)
            linksService.delLinkByUid(scid);
        model.addAttribute("title","删除成功");
        return "/admins/repass";
    }


    @RequestMapping("/getStudent")
    public String getStudent(Model model,String stuname){
        Allstudents allstudents = allstudentsService.selectStudentByName(stuname);
        model.addAttribute("Student",allstudents);
        return "/admins/get/getStudent";
    }
    @RequestMapping("/getTeacher")
    public String getTeacher(Model model,String tename){
        ArrayList<Allteachers> allteachers = allteachersService.selectLikeByName(tename);
        model.addAttribute("Teachers",allteachers);
        return "/admins/get/getTeacher";
    }
    @RequestMapping("/getCourse")
    public String getCourse(Model model,String coname){
        ArrayList<Course> courses = courseService.selectLikeCourse(coname);
        model.addAttribute("Courses",courses);
        return "/admins/get/getCourse";
    }
    @RequestMapping("/getDepartment")
    public String getDepartment(Model model,String dename){
        ArrayList<Department> departments = departmentService.selectLike(dename);
        model.addAttribute("Departments",departments);
        return "/admins/get/getDepartment";
    }
    @RequestMapping("/getMajor")
    public String getMajor(Model model,String majname){
        ArrayList<Major> majors = majorService.selectLike(majname);
        model.addAttribute("Majors",majors);
        return "/admins/get/getMajor";
    }
    @RequestMapping("/getPlace")
    public String getPlace(Model model,String plname){
        ArrayList<Place> places = placeService.selectLike(plname);
        model.addAttribute("Places",places);
        return "/admins/get/getPlace";
    }
    @RequestMapping("/getSchool")
    public String getSchool(Model model,String scname){
        ArrayList<Schools> schools = schoolsService.selectLike(scname);
        model.addAttribute("Schools",schools);
        return "/admins/get/getSchool";
    }

}
