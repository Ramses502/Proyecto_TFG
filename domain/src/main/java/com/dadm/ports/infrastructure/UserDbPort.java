package com.dadm.ports.infrastructure;

import com.dadm.model.User;

import java.util.List;

public interface UserDbPort {

    List<User> get();

    User get(String name);

    User getUser(User user);

    User login(String name, String password);

    void upload(User user);

    void update(User user);

    void deleteById(String name);

    void delete(User user);
}
