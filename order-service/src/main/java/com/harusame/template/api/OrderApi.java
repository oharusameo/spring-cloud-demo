package com.harusame.template.api;

import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.harusame.template.domain.pojo.Result;
import com.harusame.template.domain.vo.OrderVo;
import com.harusame.template.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/v1/order")
@Api("订单api")
@ApiSupport(author = "harusame")
public class OrderApi {

    @Resource
    private OrderService orderService;

    @GetMapping("/{id}")
    @ApiOperation("根据ID查询订单信息")
    public Result getById(@PathVariable("id") Integer id) {
        OrderVo orderVo = orderService.getOrderById(id);
        return Result.success(orderVo);
    }

}
