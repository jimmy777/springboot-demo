package io.abc.springboot.interfaces;

import feign.Param;
import feign.RequestLine;

public interface RemoteService {

    @RequestLine("GET /users/list?name={name}")
    String getOwner(@Param(value = "name") String name);
}
