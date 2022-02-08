package io.abc.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Y.Z.Y
 * @Descriptions: 访问access_token和更新refresh_token
     * GET http://localhost:8080/oauth/token?username=yzy&password=123&grant_type=password&client_id=password&scope=all&client_secret=123
     *
     * {
     *     "access_token": "7fe5c044-b76e-4683-af0e-826df9d853e0",
     *     "token_type": "bearer",
     *     "refresh_token": "7831e43a-d847-4126-aebb-9760bbaa405e",
     *     "expires_in": 1718,
     *     "scope": "all"
     * }
     *
     * GET http://localhost:8080/oauth/token?grant_type=refresh_token&refresh_token=7831e43a-d847-4126-aebb-9760bbaa405e&client_id=password&client_secret=123
     * {
     *     "access_token": "5a8eda21-87a2-4f9f-a04f-f07587275a5e",
     *     "token_type": "bearer",
     *     "refresh_token": "7831e43a-d847-4126-aebb-9760bbaa405e",
     *     "expires_in": 1799,
     *     "scope": "all"
     * }
     *
     * GET http://localhost:8080/hello?access_token=5a8eda21-87a2-4f9f-a04f-f07587275a5e
 * @Date: Created in 2022/2/6
 */
@RestController
public class HelloController {
    @GetMapping("/admin/hello")
    public String admin() {
        return "hello, admin";
    }

    @GetMapping("/user/hello")
    public String user() {
        return "hello, user";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
