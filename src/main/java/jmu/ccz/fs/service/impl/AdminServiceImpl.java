package jmu.ccz.fs.service.impl;


import jmu.ccz.fs.mapper.AdminMapper;
import jmu.ccz.fs.pojo.Admin;
import jmu.ccz.fs.pojo.AdminExample;
import jmu.ccz.fs.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    //spring框架为你提供mapper实现类的对象
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public String login(String name, String pwd) {
        String s="no";

        AdminExample example=new AdminExample();
        //将用户名作为条件封装进AdminExample对象
        example.createCriteria().andANameEqualTo(name);

        List<Admin> list=adminMapper.selectByExample(example);
        if(list!=null && !list.isEmpty()){
            Admin admin=list.get(0);
            if(pwd.equals(admin.getaPass())){
                s="ok";
            }
        }
        return s;
    }
    @Override
    public boolean register(Admin admin) {
        // 先判断用户名是否存在
        AdminExample example = new AdminExample();
        example.createCriteria().andANameEqualTo(admin.getaName());
        List<Admin> list = adminMapper.selectByExample(example);
        if(list != null && !list.isEmpty()){
            return false; // 用户已存在
        }
        int result = adminMapper.insertSelective(admin);
        return result > 0;
    }
}