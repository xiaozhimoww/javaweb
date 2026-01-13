package jmu.ccz.fs.service.impl;

import jmu.ccz.fs.mapper.CustomerMapper;
import jmu.ccz.fs.pojo.Customer;
import jmu.ccz.fs.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    // 注入CustomerMapper（MyBatis自动扫描注入）
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Customer customerLogin(String cUsername, String cPassword) {
        // 1. 根据账号查询顾客信息
        Customer customer = customerMapper.selectCustomerByUsername(cUsername);
        // 2. 验证（账号存在 + 密码匹配，此处为明文验证，生产环境需加密）
        if (customer != null && cPassword.equals(customer.getcPassword())) {
            return customer; // 登录成功，返回顾客信息
        }
        return null; // 登录失败
    }
}