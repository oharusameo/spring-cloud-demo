package com.harusame.template.feign;

import com.harusame.template.domain.pojo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("user-service")
@RequestMapping("/api/v1/user")
public interface UserFeignClient {

    @GetMapping("/{id}")
    Result getUserById(@PathVariable("id") Integer id);


}
