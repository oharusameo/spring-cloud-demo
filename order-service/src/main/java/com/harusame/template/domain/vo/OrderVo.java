package com.harusame.template.domain.vo;

import com.harusame.template.domain.pojo.Order;
import com.harusame.template.domain.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderVo {
    private Order order;
    private User user;
}
