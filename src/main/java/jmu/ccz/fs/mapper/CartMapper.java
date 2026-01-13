package jmu.ccz.fs.mapper;

import jmu.ccz.fs.pojo.CartShop;

import java.util.List;

public interface CartMapper {

    // 插入新购物车记录
    int insert(CartShop cart);

    // 根据用户ID和商品ID查购物车记录
    CartShop selectByUidPid(CartShop cart);

    // 更新购物车中某个商品的数量（累加）
    int updateNumbers(CartShop cart);

    List<CartShop> selectAll();
}
