package io.abc.springboot;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@Order(3)
public class MyApplicationRunner1 implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        // TODO: 2022/1/23  
        List<String> nonOptionArgs = args.getNonOptionArgs();
        System.out.println("自定义ApplicationRunner1 >>> " + nonOptionArgs);
        Set<String> optionNames = args.getOptionNames();
        for (String optionName: optionNames) {
            System.out.println("ApplicationRunner1- key:" + optionName + "; value:" + args.getOptionValues(optionName));
        }
    }
}
