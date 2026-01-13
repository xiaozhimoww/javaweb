package jmu.ccz.fs.service;

import jmu.ccz.fs.pojo.Admin;

public interface AdminService {
    //登录
    public String login(String name, String pwd);

    boolean register(Admin admin);
}
