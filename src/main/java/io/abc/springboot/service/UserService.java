package io.abc.springboot.service;

import io.abc.springboot.model.UserRecord;
import io.abc.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    // TODO: 2022/1/28

    @Autowired
    private UserRepository userRepository;
    public List<UserRecord> getAllUsers()
    {
        List<UserRecord> userRecords = new ArrayList<>();
        userRepository.findAll().forEach(userRecords::add);
        return userRecords;
    }
    public void addUser(UserRecord userRecord)
    {
        userRepository.save(userRecord);
    }
}
