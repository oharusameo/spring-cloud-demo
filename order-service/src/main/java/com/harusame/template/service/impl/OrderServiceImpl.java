package com.harusame.template.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.harusame.template.domain.pojo.Order;
import com.harusame.template.domain.pojo.Result;
import com.harusame.template.domain.pojo.User;
import com.harusame.template.domain.vo.OrderVo;
import com.harusame.template.exception.BusinessException;
import com.harusame.template.feign.UserFeignClient;
import com.harusame.template.mapper.OrderMapper;
import com.harusame.template.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author ggzst
 * @description 针对表【t_order】的数据库操作Service实现
 * @createDate 2023-11-21 11:54:39
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
        implements OrderService {
    @Resource
    private OrderMapper orderMapper;
/*        @Resource
    private RestTemplate restTemplate;*/
    @Resource
    private UserFeignClient userFeignClient;

    @Override
    public OrderVo getOrderById(Integer id) {
        Order order = orderMapper.selectById(id);
        if (order == null) {
            throw new RuntimeException("订单不存在");
        }

/*        String url = "http://user-service/api/v1/user/" + order.getUserId();
        Result result = restTemplate.getForObject(url, Result.class);*/
        Result result = userFeignClient.getUserById(order.getUserId());
        if (Objects.requireNonNull(result).getStatusCode() != 200) {
            throw new BusinessException(result.getMessage());
        }
        JsonMapper jsonMapper = new JsonMapper();
        User user = jsonMapper.convertValue(result.getData(), User.class);
        return new OrderVo(order, user);
    }
}




