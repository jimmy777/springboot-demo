package io.abc.springboot;

import io.abc.springboot.component.JmsComponent;
import io.abc.springboot.vo.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @Author: Y.Z.Y
 * @Descriptions:
 * @Date: Created in 2022/2/13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test1 {
    @Autowired
    JmsComponent jmsComponent;

    @Test
    public void contextLoads() {
        Message msg = new Message();
        msg.setContent("hello jms!");
        msg.setDate(new Date());
        jmsComponent.send(msg);
    }
}
