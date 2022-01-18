package io.abc.springboot.controllers.Feign;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "users")
public class UserController {
    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
    @ResponseBody
    public String list(@org.jetbrains.annotations.NotNull @RequestParam String name) {
        return name.toUpperCase();
    }
}
