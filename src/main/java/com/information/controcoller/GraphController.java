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
import java.util.*;

@Controller
@RequestMapping("/graph")
public class GraphController {
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

    public static String getName(HttpSession session)throws IOException {
        Users userlogin = (Users)session.getAttribute("userlogin");
        System.out.println("username:"+userlogin.getUsername());

        return userlogin.getUsername();
    }
    //教师
    //全部图谱
    @RequestMapping("/show")
    public String graphshow(Model model) throws IOException {
        return "/teachers/graph";
    }
    //个人图谱
    @RequestMapping("/showinfo")
    public String graphshowinfo( Model model) throws IOException {
        return "/teachers/graphinfo";
    }
    //个人二级图谱
    @RequestMapping("/graphinfo2")
    public String graphinfo2( Model model) throws IOException {
        return "/teachers/graphinfo2";
    }

    //学生
    //全部图谱
    @RequestMapping("/shows")
    public String graphshows(Model model) throws IOException {
        return "/students/graphs";
    }
    //个人图谱
    @RequestMapping("/showinfos")
    public String graphshowinfos( Model model) throws IOException {
        return "/students/graphinfos";
    }
    //个人二级图谱
    @RequestMapping("/graphinfo2s")
    public String graphinfo2s( Model model) throws IOException {
        return "/students/graphinfo2s";
    }

    //管理员
    //全部图谱
    @RequestMapping("/showadmin")
    public String graphshowadmin(Model model) throws IOException {
        return "/admins/grapha";
    }
    //查询节点及其图谱
    @RequestMapping("/getGraph2Show")
    public String getGraph2Show(String nodename,Model model,HttpSession httpSession) throws IOException {
        if(allnodesService.selectNodeByName(nodename)!=null) {
            //查询此节点
            Allnodes allnodes = allnodesService.selectNodeByName(nodename);
            System.out.println(allnodes.getName());
            model.addAttribute("nodes", allnodes);
            //返回此节点信息
            String username=getName(httpSession);
            Users users=usersService.selectTnumByTname(username);
            int type=users.getType();
            if(type==1){return "/students/graphget";}
            else if(type==2){return "/teachers/graphget";}
            else if(type==3){return "/admins/graphget";}
            else {return "/404";}
        }
        else {
            return "/404";
        }

    }

    //查询节点
    @RequestMapping("/show2s")
    @ResponseBody
    public ArrayList<Allnodes> graphshow2s(String nodename) throws IOException {
        ArrayList<Allnodes> allnodes=new ArrayList<>();
        //利用前端获取的此节点信息查询该节点
        Allnodes allnodes1=allnodesService.selectNodeByName(nodename);
        //将该节点添加到要展示的节点数组中
        allnodes.add(allnodes1);
        System.out.println(allnodes1.getUid());
        //如果节点不为空，则利用该节点查到的关系查询对应节点，并添加到要展示的节点数组中
        if(allnodes1!=null){
            //查询该节点关系
            ArrayList<Links> links=linksService.selectLinByUID(allnodes1.getUid());
            for (Links link : links) {
                //通过查询到的节点对应关系ID查询对应节点，并添加到数组中
                if (Objects.equals(link.getSource(), allnodes1.getUid())) {
                    allnodes.add(allnodesService.selectByUID(link.getTarget()));
                    System.out.println(link);
                } else if (Objects.equals(link.getTarget(), allnodes1.getUid())) {
                    allnodes.add(allnodesService.selectByUID(link.getSource()));
                    System.out.println(link);
                }
                else{
                    System.out.println("allnodes_err");
                }
            }
        }
        else{
            System.out.println("allnodes_err");
        }
        return allnodes;
    }
    //查询节点关系
    @RequestMapping("/show3s")
    @ResponseBody
    public ArrayList<Links> graphshow3s(String nodename) throws IOException {
        Allnodes allnodes1=allnodesService.selectNodeByName(nodename);
        return linksService.selectLinByUID(allnodes1.getId());
    }

    //展示用数据
    //展示用节点
    @RequestMapping("/show2")
    @ResponseBody
    public ArrayList<Nodes> graphshow2() throws IOException {
        return nodesService.selectAll();
    }
    //展示用关系
    @RequestMapping("/show3")
    @ResponseBody
    public ArrayList<Links> graphshow3() throws IOException {
        return linksService.selectAll();
    }
    //个人节点及对应关系节点
    @RequestMapping("/show4")
    @ResponseBody
    public ArrayList<Allnodes> graphshowinfo1(HttpSession httpSession) throws IOException{
        //用户名
        String username=AllteacherController.getName(httpSession);
        //用户信息
        Users users = usersService.selectTnumByTname(username);
        //学号、教工号
        String usernum=users.getUsernum();
        //查询实体
        String name = null;
        String eid = null;
        if(users.getType()==1) {
            Allstudents allstudents = allstudentsService.selectStudentNameByNum(usernum);
            //实体ID
            eid = allstudents.getStid();
            System.out.println(eid);
            //实体Name
            name = allstudents.getStuname();
            System.out.println(name);
        }
        else if(users.getType()==2) {
            Allteachers allteachers = allteachersService.selectTeacherNameByNum(usernum);

            //实体ID
            eid = allteachers.getTeid();
            System.out.println(eid);
            //实体Name
            name = allteachers.getTeName();
            System.out.println(name);
        }
        //插入实体
        ArrayList<Allnodes> allnodes=new ArrayList<>();
        allnodes.add(allnodesService.selectNodeByName(name));
        //实体相关关系
        ArrayList<Links> links=linksService.selectLinByUID(eid);
        //相关节点
        for (Links link : links) {
            if (Objects.equals(link.getSource(), eid)) {
                allnodes.add(allnodesService.selectByUID(link.getTarget()));
                System.out.println(link);
            } else if (Objects.equals(link.getTarget(), eid)) {
                allnodes.add(allnodesService.selectByUID(link.getSource()));
                System.out.println(link);
            }
            else{
                System.out.println("allnodes_err");
            }
        }
        return allnodes;
    }
    //个人对应关系
    @RequestMapping("/show5")
    @ResponseBody
    public ArrayList<Links> graphshowinfo2(HttpSession httpSession) throws IOException{
        String username=AllteacherController.getName(httpSession);
        Users users = usersService.selectTnumByTname(username);
        String usernum=users.getUsernum();
        String eid=null;
        if(users.getType()==1) {
            Allstudents allstudents = allstudentsService.selectStudentNameByNum(usernum);
            eid = allstudents.getStid();
        }
        else if(users.getType()==2) {
            Allteachers allteachers = allteachersService.selectTeacherNameByNum(usernum);
            eid = allteachers.getTeid();
        }
        return linksService.selectLinByUID(eid);
    }
    //个人对应关系节点，及对应节点的对应关系节点（二级节点）
    @RequestMapping("/show6")
    @ResponseBody
    public ArrayList<Nodes> graphinfo2link(HttpSession httpSession) throws IOException{
        ArrayList<Nodes> nodes=new ArrayList<>();
        String username=AllteacherController.getName(httpSession);
        Users users = usersService.selectTnumByTname(username);

        String usernum=users.getUsernum();
        String eid=null;
//        System.out.println(users.getType());
        if(users.getType()==1) {
            Allstudents allstudents = allstudentsService.selectStudentNameByNum(usernum);
            eid = allstudents.getStid();
        }
        else if(users.getType()==2) {
            Allteachers allteachers = allteachersService.selectTeacherNameByNum(usernum);
            eid = allteachers.getTeid();
        }

        ArrayList<Links> links=linksService.selectLinByUID(eid);
//        nodes.add(nodesService.selectByUID(eid));
        for (Links link : links) {
            if (Objects.equals(link.getSource(), eid)) {
                String uid = nodesService.selectByUID(link.getTarget()).getId();
                if(!Objects.equals(nodesService.selectByUID(link.getTarget()).getId(), "null"))
                    //添加二级节点函数
                    anothernode(nodes, uid);
//                System.out.println("2"+(nodesService.selectByUID(link.getTarget()).getId()));
            } else if (Objects.equals(link.getTarget(), eid)) {
                String uid = nodesService.selectByUID(link.getSource()).getId();
                if(!Objects.equals(nodesService.selectByUID(link.getTarget()).getId(), "null"))
                    anothernode(nodes, uid);
//                System.out.println("2"+(nodesService.selectByUID(link.getTarget()).getId()));
            }
            else{
                System.out.println("nodes_err");
            }
        }
        //节点数组去重
        ArrayList<Nodes> nodes1=new ArrayList<>();
        ArrayList<Nodes> nodes2=new ArrayList<>();
        int f=0;
        int size=nodes.size();
        for(int i=0;i<size;i++){
            if(nodes.get(i)!=null){
                nodes1.add(nodes.get(i));
            }
        }
        for(int i=0;i<nodes1.size();i++){
            boolean isrepeat = true;
            for(int j=i+1;j<nodes1.size();j++){
                if(Objects.equals(nodes1.get(j).getId(), nodes1.get(i).getId())){
                    isrepeat = false;
                    break;
                }
            }
            if(isrepeat){
            nodes2.add(nodes1.get(i));
            }
        }
        return nodes2;
    }
    //个人二级节点添加
    private void anothernode(ArrayList<Nodes> nodes, String uid) {
        nodes.add(nodesService.selectByUID(uid));
        ArrayList<Links> links2=linksService.selectLinByUID(uid);
        for (Links links1:links2){
            if (Objects.equals(links1.getSource(), uid)){
                if(nodesService.selectByUID(links1.getTarget())!=null){
                nodes.add(nodesService.selectByUID(links1.getTarget()));
                System.out.println("1"+nodesService.selectByUID(links1.getTarget()));}
            }
            else if(Objects.equals(links1.getTarget(), uid)){
                if(nodesService.selectByUID(links1.getTarget())!=null){
                nodes.add(nodesService.selectByUID(links1.getSource()));
                System.out.println("1"+nodesService.selectByUID(links1.getTarget()));}
            }
            else{
                System.out.println("err_err");
            }
        }
    }
    //个人节点的二级关系
    @RequestMapping("/show7")
    @ResponseBody
    public ArrayList<Links> graphinfo2node(HttpSession httpSession) throws IOException{
        ArrayList<Links> links=new ArrayList<>();

        String username=AllteacherController.getName(httpSession);
        Users users = usersService.selectTnumByTname(username);

        String usernum=users.getUsernum();
        String eid=null;
        if(users.getType()==1) {
            Allstudents allstudents = allstudentsService.selectStudentNameByNum(usernum);
            eid = allstudents.getStid();
        }
        else if(users.getType()==2) {
            Allteachers allteachers = allteachersService.selectTeacherNameByNum(usernum);
            eid = allteachers.getTeid();
        }

        ArrayList<Links> links1=linksService.selectLinByUID(eid);
        for (Links links2:links1){
            links.add(links2);
            String uid = allnodesService.selectByUID(links2.getTarget()).getUid();
            ArrayList<Links> links3= linksService.selectLinByUID(uid);
            links.addAll(links3);
        }
        return links;
    }
    //getGraphByIdAndName
    @RequestMapping("/getGraph")
    public String getGraph(HttpSession httpSession,String nodeid, String nodename, Model model)throws IOException{
        //用于区分节点类型，便于快速查找
        String idtype=nodeid.substring(0,2);
//        System.out.println(idtype);
        String username=AllteacherController.getName(httpSession);
        Users users = usersService.selectTnumByTname(username);
//        System.out.println(users.getType());
        //区分用户类型进行不同功能页面分流
        if(users.getType()==2){
        switch (idtype) {
            case "SC":
                Schools schools = schoolsService.selectByName(nodename);
                model.addAttribute("School", schools);
                return "/teachers/graphgetSchool";
            case "CO":
                Course course = courseService.selectByName(nodename);
                model.addAttribute("Course", course);
                return "/teachers/graphgetCourse";
            case "DE":
                DepartmentWithBLOBs department = departmentService.selectByID(nodeid);
                model.addAttribute("Department", department);
                return "/teachers/graphgetDepartment";
            case "MA":
                Major major = majorService.selectByName(nodename);
                model.addAttribute("Major", major);
                return "/teachers/graphgetMajor";
            case "ST":
                Allstudents allstudents = allstudentsService.selectByID(nodeid);
                model.addAttribute("Student", allstudents);
                return "/teachers/graphgetStudent";
            case "TE":
                Allteachers allteachers1 = allteachersService.selectByID(nodeid);
                String tenum=allteachers1.getTeNum();
                ArrayList<Allteachers> allteachers = allteachersService.selectTeacherByNum(tenum);
                model.addAttribute("allteacher", allteachers);
                return "/teachers/graphgetTeacher";
            case "PL":
                Place place = placeService.selectByName(nodename);
                model.addAttribute("Place",place);
                return "/teachers/graphgetPlace";
            default:
                return "/404";
            }
        }
        else if(users.getType()==1) {
                switch (idtype) {
                    case "SC":
                        Schools schools = schoolsService.selectByName(nodename);
                        model.addAttribute("School", schools);
                        return "/students/graphgetSchoolS";
                    case "CO":
                        Course course = courseService.selectByName(nodename);
                        model.addAttribute("Course", course);
                        return "/students/graphgetCourseS";
                    case "DE":
                        DepartmentWithBLOBs department = departmentService.selectByID(nodeid);
                        model.addAttribute("Department", department);
                        return "/students/graphgetDepartmentS";
                    case "MA":
                        Major major = majorService.selectByName(nodename);
                        model.addAttribute("Major", major);
                        return "/students/graphgetMajorS";
                    case "ST":
                        Allstudents allstudents = allstudentsService.selectByID(nodeid);
                        model.addAttribute("Student", allstudents);
                        return "/students/graphgetStudentS";
                    case "TE":
                        Allteachers allteachers1 = allteachersService.selectByID(nodeid);
                        String tenum=allteachers1.getTeNum();
                        ArrayList<Allteachers> allteachers = allteachersService.selectTeacherByNum(tenum);
                        model.addAttribute("allteacher", allteachers);
                        return "/students/graphgetTeacherS";
                    case "PL":
                        Place place = placeService.selectByName(nodename);
                        model.addAttribute("Place",place);
                        return "/students/graphgetPlaceS";
                    default:
                        return "/404";
                }
        }
        else {
            switch (idtype) {
                case "SC":
                    Schools schools = schoolsService.selectByName(nodename);
                    model.addAttribute("School", schools);
                    return "/admins/graphgetSchoolA";
                case "CO":
                    Course course = courseService.selectByName(nodename);
                    model.addAttribute("Course", course);
                    return "/admins/graphgetCourseA";
                case "DE":
                    DepartmentWithBLOBs department = departmentService.selectByID(nodeid);
                    model.addAttribute("Department", department);
                    return "/admins/graphgetDepartmentA";
                case "MA":
                    Major major = majorService.selectByName(nodename);
                    model.addAttribute("Major", major);
                    return "/admins/graphgetMajorA";
                case "ST":
                    Allstudents allstudents = allstudentsService.selectByID(nodeid);
                    model.addAttribute("Student", allstudents);
                    return "/admins/graphgetStudentA";
                case "TE":
                    Allteachers allteachers1 = allteachersService.selectByID(nodeid);
                    String tenum=allteachers1.getTeNum();
                    ArrayList<Allteachers> allteachers = allteachersService.selectTeacherByNum(tenum);
                    model.addAttribute("allteacher", allteachers);
                    return "/admins/graphgetTeacherA";
                case "PL":
                    Place place = placeService.selectByName(nodename);
                    model.addAttribute("Place",place);
                    return "/admins/graphgetPlaceA";
                default:
                    return "/404";
            }
        }
    }
}
