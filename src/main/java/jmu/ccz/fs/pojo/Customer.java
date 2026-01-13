package jmu.ccz.fs.pojo;

import java.util.Date;

public class Customer {
    // 对应数据库表字段
    private Integer cId;
    private String cUsername;
    private String cPassword;
    private String cName;
    private String cPhone;
    private Date createTime;
    private Date updateTime;

    // 无参构造器（MyBatis反射需要）
    public Customer() {}

    // 全参构造器（可选）
    public Customer(Integer cId, String cUsername, String cPassword, String cName, String cPhone, Date createTime, Date updateTime) {
        this.cId = cId;
        this.cUsername = cUsername;
        this.cPassword = cPassword;
        this.cName = cName;
        this.cPhone = cPhone;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    // getter和setter方法（必须完整，用于属性赋值和取值）
    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcUsername() {
        return cUsername;
    }

    public void setcUsername(String cUsername) {
        this.cUsername = cUsername;
    }

    public String getcPassword() {
        return cPassword;
    }

    public void setcPassword(String cPassword) {
        this.cPassword = cPassword;
    }

    // 其他字段的getter/setter省略，需补充完整
}