package io.abc.feign;


import feign.Feign;
import feign.Request;
import feign.Retryer;
import io.abc.springboot.interfaces.RemoteService;
import org.junit.jupiter.api.Test;

public class TestFeign {

    @Test
    public void test1() {
        RemoteService target = Feign.builder()
                .options(new Request.Options(1000, 3500))
                .retryer(new Retryer.Default(5000, 5000, 3))
                .target(RemoteService.class, "http://localhost:8080");

        String result = target.getOwner("scott");

        System.out.println(result);
    }
}
