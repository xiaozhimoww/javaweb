package jmu.ccz.fs.service;

import jmu.ccz.fs.pojo.CartShop;

import java.util.List;

public interface CartService {
    boolean addToCart(Integer uid, Integer pid, Integer quantity);

    List<CartShop> getAllCart();
}
