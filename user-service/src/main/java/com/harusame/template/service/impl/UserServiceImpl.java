package com.harusame.template.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.harusame.template.mapper.UserMapper;
import com.harusame.template.domain.pojo.User;
import com.harusame.template.service.UserService;
import org.springframework.stereotype.Service;

/**
* @author ggzst
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2023-11-21 11:59:32
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




