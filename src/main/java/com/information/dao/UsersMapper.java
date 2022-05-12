package com.information.dao;

import com.information.entity.Page;
import com.information.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface UsersMapper {
    void deleteByPrimaryKey(String username);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    Users selectByTeacher(@Param("teachername") String teachername, @Param("teacherpwd")  String teacherpwd, @Param("teacher")  int teacher);

    Users selectByStudent(@Param("studentname") String studentname,@Param("studentpwd")  String studentpwd,@Param("student")  int student);

    Users selectByAdmin(@Param("adminname") String adminname,@Param("adminpwd")  String adminpwd,@Param("admin")  int admin);

    Users selectByTName(String teachername);

    boolean updateuser(@Param("username")String username,@Param("userpwd")String userpwd);

    Users selectByUser(@Param("username")String username,@Param("userpwd")String userpwd);

    ArrayList<Users> getUserByPage(Page<Users> pages);

    ArrayList<Users> selectAll();

    Users selectByUid(String stid);

    void insertUser(@Param("stid") String stid,@Param("stuname") String stuname,
                    @Param("password") String password,@Param("school") String school,
                    @Param("stunum") String stunum, @Param("type") int type);
}