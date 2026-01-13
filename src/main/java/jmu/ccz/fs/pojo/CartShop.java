package jmu.ccz.fs.pojo;

public class CartShop {

    private Integer cid;     // 购物车ID
    private Integer uid;     // 用户ID
    private Integer pid;     // 商品ID
    private Integer numbers; // 数量



    public CartShop(Integer uid, Integer pid, Integer numbers) {
        this.uid = uid;
        this.pid = pid;
        this.numbers = numbers;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getNumbers() {
        return numbers;
    }

    public void setNumbers(Integer numbers) {
        this.numbers = numbers;
    }
}
