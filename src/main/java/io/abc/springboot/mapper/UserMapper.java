package io.abc.springboot.mapper;

import io.abc.springboot.model.Role;
import io.abc.springboot.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    // TODO: 2022/2/4

    User loadUserByUsername(String username);
    List<Role> getUserRolesByUid(Integer id);
}
