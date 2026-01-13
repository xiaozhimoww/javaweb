package jmu.ccz.fs.service;

import jmu.ccz.fs.pojo.Customer;

public interface CustomerService {

    Customer customerLogin(String cUsername, String cPassword);
}