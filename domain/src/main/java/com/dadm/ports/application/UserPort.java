package com.dadm.ports.application;

import com.dadm.model.User;

import java.util.List;

public interface UserPort {

    List<User> get();

    User get(String name);

    void createUser(User user);

    void updateUser(User user);

    void deleteUser(User user);

    void deleteUserById(String name);

}
