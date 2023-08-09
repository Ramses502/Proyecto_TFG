package com.dadm.services;

import com.dadm.model.User;
import com.dadm.ports.application.UserPort;
import com.dadm.ports.infrastructure.UserDbPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserUseCase implements UserPort {

    private final UserDbPort userDBPort;

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
    public void deleteUser(User user) {
        userDBPort.delete(user);
    }

    @Override
    public void deleteUserById(String name) {
        userDBPort.deleteById(name);
    }

}
