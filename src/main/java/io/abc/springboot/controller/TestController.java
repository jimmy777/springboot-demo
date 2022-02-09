package io.abc.springboot.controller;

/**
 * @Author: Y.Z.Y
 * @Descriptions:
 * @Date: Created in 2022/2/8
 */

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@RequestMapping("/test")
@RestController
public class TestController {

    @GetMapping("page")
    public ModelAndView page() {
        return new ModelAndView("mysocket");
    }

    @RequestMapping("/push/{toUserId}")
    public ResponseEntity<String> pushToWeb(String message, @PathVariable String toUserId) throws IOException {
        WebSocketServer.sendInfo(message, toUserId);
        return ResponseEntity.ok("msg send success!!!");
    }
}
