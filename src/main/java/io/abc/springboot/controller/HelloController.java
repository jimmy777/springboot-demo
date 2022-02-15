package io.abc.springboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Y.Z.Y
 * @Descriptions:
 * @Date: Created in 2022/2/14
 */
@RestController
@Api(tags = "测试swagger接口")
public class HelloController {

    @ApiOperation(value = "第一个接口例子")
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Springboot!";
    }
}
