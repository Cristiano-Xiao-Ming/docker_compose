package com.compose.user.controller;


import com.compose.user.feign.ProductFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@Slf4j
public class UserController {

    @Resource
    private ProductFeign productFeign;

    @GetMapping("/user/getProductInfo")
    public Map<String, Object> getProductInfo(@RequestParam String id) {
        Map<String, Object> map = productFeign.find(id);
        log.info("返回的信息:[{}]" + map);
        return map;
    }
}


