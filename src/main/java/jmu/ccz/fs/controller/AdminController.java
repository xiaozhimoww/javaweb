package jmu.ccz.fs.controller;

import jmu.ccz.fs.service.AdminService;
import jmu.ccz.fs.service.CustomerService;
import jmu.ccz.fs.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/doLogin")
    public String doLogin(String name, String pwd, String userType, Model model, HttpSession session) {

        if ("admin".equals(userType)) {
            String s = adminService.login(name, pwd);
            if ("ok".equals(s)) {
                session.setAttribute("adminName", name);
                return "main";
            } else {
                model.addAttribute("errmsg", "管理员用户名或密码不正确！");
                return "login";
            }
        } else if ("customer".equals(userType)) {
            Customer customer = customerService.customerLogin(name, pwd);
            if (customer != null) {
                session.setAttribute("customer", customer);
                return "main1";
            } else {
                model.addAttribute("errmsg", "顾客用户名或密码不正确！");
                return "login";
            }
        } else {
            model.addAttribute("errmsg", "请选择用户类型！");
            return "login";
        }
    }
}
