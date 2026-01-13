package jmu.ccz.fs.service.impl;

import jmu.ccz.fs.mapper.XmOrderMapper;
import jmu.ccz.fs.pojo.XmOrder;
import jmu.ccz.fs.service.XmOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class XmOrderServiceImpl implements XmOrderService {

    @Autowired
    private XmOrderMapper xmOrderMapper;

    @Override
    @Transactional
    public boolean addOrder(XmOrder order) {
        int n = xmOrderMapper.insert(order);
        return n > 0;
    }

    @Override
    public List<XmOrder> getAllOrders() {
        return xmOrderMapper.selectAll();
    }
}
