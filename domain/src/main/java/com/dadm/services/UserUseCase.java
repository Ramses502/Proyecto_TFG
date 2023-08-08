package com.dadm.services;

import com.dadm.model.User;
import com.dadm.ports.application.UserPort;
import com.dadm.ports.infrastructure.UserDbPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserUseCase implements UserPort {

    private final UserDbPort userDBPort;

    public UserUseCase(UserDbPort userDBPort) {
        this.userDBPort = userDBPort;
    }

    @Override
    public List<User> get() {
        return userDBPort.get();
    }

    @Override
    public User get(String name) {
        return userDBPort.get(name);
    }

    @Override
    public void createUser(User user) {
        userDBPort.upload(user);
    }

    @Override
    public void updateUser(User user) {
        userDBPort.update(user);
    }

    @Override
    public void deleteUser(String name) {
        userDBPort.deleteById(name);
    }

}
