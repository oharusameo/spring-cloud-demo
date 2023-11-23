package com.harusame.template.service;

import com.harusame.template.domain.pojo.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.harusame.template.domain.vo.OrderVo;

/**
* @author ggzst
* @description 针对表【t_order】的数据库操作Service
* @createDate 2023-11-21 11:54:39
*/
public interface OrderService extends IService<Order> {

    OrderVo getOrderById(Integer id);
}
