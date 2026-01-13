package jmu.ccz.fs.service.impl;

import jmu.ccz.fs.mapper.CartMapper;
import jmu.ccz.fs.mapper.ProductInfoMapper;
import jmu.ccz.fs.mapper.XmOrderMapper;
import jmu.ccz.fs.pojo.CartShop;
import jmu.ccz.fs.pojo.ProductInfo;
import jmu.ccz.fs.pojo.XmOrder;
import jmu.ccz.fs.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private ProductInfoMapper productMapper;

    @Autowired
    private XmOrderMapper orderMapper;

    @Override
    @Transactional
    public boolean addToCart(Integer uid, Integer pid, Integer quantity) {

        // 1. 查商品
        ProductInfo product = productMapper.selectByPrimaryKey(pid);
        if (product == null || product.getpNumber() < quantity) {
            return false;
        }

        // 2. 查购物车是否已有相同商品
        CartShop existing = cartMapper.selectByUidPid(new CartShop(uid, pid, 0));
        if (existing != null) {
            existing.setNumbers(existing.getNumbers() + quantity);
            cartMapper.updateNumbers(existing);
        } else {
            cartMapper.insert(new CartShop(uid, pid, quantity));
        }

        // 3. 扣库存
        productMapper.reduceStock(pid, quantity);

        // 4. 生成订单
        XmOrder order = new XmOrder();
        order.setOid(UUID.randomUUID().toString().replace("-", ""));
        order.setUid(uid);
        order.setAddressId(null);
        order.setTotalprice((double) (product.getpPrice() * quantity));
        order.setRemarks("");
        order.setStatus("待发货");

        orderMapper.insert(order);

        return true;
    }
    @Override
    public List<CartShop> getAllCart() {
        return cartMapper.selectAll();
    }
}
