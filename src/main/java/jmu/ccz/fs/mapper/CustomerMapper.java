package jmu.ccz.fs.mapper;


import jmu.ccz.fs.pojo.Customer;
import org.apache.ibatis.annotations.Param;

public interface CustomerMapper {

    Customer selectCustomerByUsername(@Param("cUsername") String cUsername);
}