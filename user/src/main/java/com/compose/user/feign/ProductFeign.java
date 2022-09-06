package com.compose.user.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author Cristianoxm
 */
@FeignClient(value = "product")
public interface ProductFeign {
    @GetMapping("/product/find")
    Map<String,Object> find(@RequestParam("id") String id);
}
