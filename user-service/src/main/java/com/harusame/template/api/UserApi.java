package com.harusame.template.api;

import com.harusame.template.domain.pojo.Result;
import com.harusame.template.domain.pojo.User;
import com.harusame.template.exception.BusinessException;
import com.harusame.template.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/v1/user")
@Api(tags = "用户模块",value = "UserApi")
@Slf4j

public class UserApi {

    @Resource
    private UserService userService;
    @GetMapping("/{id}")
    @ApiOperation("根据用户ID获取用户信息")
    public Result getUserById(@PathVariable("id") Integer id){
        User user = userService.getById(id);
        if (user==null){
            throw new BusinessException("没有查询到对应的用户信息");
        }
        return Result.success(user);
    }

}
