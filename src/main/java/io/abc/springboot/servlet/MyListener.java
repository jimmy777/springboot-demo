package io.abc.springboot.servlet;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyListener implements ServletRequestListener {
    // TODO: 2022/1/23

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("MyListener >>> requestDestroyed");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("MyListener >>> requestInitialized");
    }
}
