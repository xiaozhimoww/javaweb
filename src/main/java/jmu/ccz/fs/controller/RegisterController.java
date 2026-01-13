package jmu.ccz.fs.controller;

import jmu.ccz.fs.pojo.Admin;
import jmu.ccz.fs.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/regist")
public class RegisterController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/doRegist.action")
    public String doRegist(HttpServletRequest request) {
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        String userType = request.getParameter("userType");

        if(name == null || name.isEmpty() || pwd == null || pwd.isEmpty()){
            request.setAttribute("errmsg", "用户名或密码不能为空！");
            return "regist";
        }

        if("admin".equals(userType)){
            Admin admin = new Admin();
            admin.setaName(name);
            admin.setaPass(pwd);
            boolean success = adminService.register(admin);
            if(success){
                request.setAttribute("msg", "管理员注册成功，请登录！");
                return "login";
            } else {
                request.setAttribute("errmsg", "用户名已存在！");
                return "regist";
            }
        }

        request.setAttribute("errmsg", "暂不支持此用户类型注册！");
        return "regist";
    }
}
