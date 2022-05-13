package com.information.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.information.dao.AllstudentsMapper;
import com.information.dao.AllteachersMapper;
import com.information.entity.Allstudents;
import com.information.entity.Allteachers;
import com.information.entity.AllteachersWithBLOBs;
import com.information.service.CommonService;
import com.information.util.JasperPdfUtil;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

@Service("/CommonService")
public class CommonServiceImpl implements CommonService {
    @Autowired
    private AllstudentsMapper allstudentsMapper;
    @Autowired
    private AllteachersMapper allteachersMapper;
    @Override
    public byte[] exportPdf2(String stunum) throws FileNotFoundException, JRException {
        String templatePath = "contract.jrxml";
        Allstudents contract = new Allstudents();
        contract.setStuname(allstudentsMapper.selectByNum2(stunum).getStuname());
        contract.setAge(allstudentsMapper.selectByNum2(stunum).getAge());
        contract.setMajor(allstudentsMapper.selectByNum2(stunum).getMajor());
        contract.setNation(allstudentsMapper.selectByNum2(stunum).getNation());
        contract.setPlace(allstudentsMapper.selectByNum2(stunum).getPlace());
        contract.setSex(allstudentsMapper.selectByNum2(stunum).getSex());
        contract.setLauguageAbility(allstudentsMapper.selectByNum2(stunum).getLauguageAbility());
        contract.setPolitical(allstudentsMapper.selectByNum2(stunum).getPolitical());
        contract.setStunum(allstudentsMapper.selectByNum2(stunum).getStunum());
        contract.setSchool(allstudentsMapper.selectByNum2(stunum).getSchool());
        contract.setTelephone(allstudentsMapper.selectByNum2(stunum).getTelephone());
        return JasperPdfUtil.exportPdfFromXml(templatePath, BeanUtil.beanToMap(contract));
    }
    @Override
    public byte[] exportPdf1(String tenum) throws FileNotFoundException, JRException {
        String templatePath = "contract1.jrxml";
        Allteachers contract = new Allteachers();
        contract.setTeTitle(allteachersMapper.selectNameByNum(tenum).getTeTitle());
        contract.setDepartment(allteachersMapper.selectNameByNum(tenum).getDepartment());
        contract.setEmail(allteachersMapper.selectNameByNum(tenum).getEmail());
        contract.setMajor(allteachersMapper.selectNameByNum(tenum).getMajor());
        contract.setSchool(allteachersMapper.selectNameByNum(tenum).getSchool());
        contract.setPostcode(allteachersMapper.selectNameByNum(tenum).getPostcode());
        contract.setTeIdentity(allteachersMapper.selectNameByNum(tenum).getTeIdentity());
        contract.setTeName(allteachersMapper.selectNameByNum(tenum).getTeName());
        contract.setTeNum(allteachersMapper.selectNameByNum(tenum).getTeNum());
        contract.setTeTelephone(allteachersMapper.selectNameByNum(tenum).getTeTelephone());
        contract.setAwards(allteachersMapper.selectNameByNum(tenum).getAwards());
        contract.setAchievements(allteachersMapper.selectNameByNum(tenum).getAchievements());
        return JasperPdfUtil.exportPdfFromXml(templatePath, BeanUtil.beanToMap(contract));
    }
}
