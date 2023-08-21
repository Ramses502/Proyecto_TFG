package com.dadm.adapter;

import com.dadm.mapper.*;
import com.dadm.model.*;
import com.dadm.ports.infrastructure.UserDbPort;
import com.dadm.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class UserDbAdapter implements UserDbPort {

    private final UserDbMapper mapper = UserDbMapper.INSTANCE;

    private final UserRepository userRepository;

    @Override
    public List<User> get() {
        return userRepository.findAll()
                .stream()
                .map(mapper::aDominio)
                .collect(Collectors.toList());
    }

    @Override
    public User get(String name) {
        UserMO userMO = userRepository.getOne(name);
        return mapper.aDominio(userMO);
    }

    @Override
    public User getUser(User user) {
        return mapper.aDominio(userRepository.findById(user.getName())
                .orElseThrow(() -> new RuntimeException("No existe usuario")));
    }

    @Override
    public User login(String name, String password) {
        return mapper.aDominio(userRepository.login(name, password).orElse(new UserMO("", "", 0, null, null)));
    }

    @Override
    public void upload(User user) {
        UserMO userMO = mapper.aDb(user);
        userRepository.save(userMO);
    }

    @Override
    public void update(User user) {
        UserMO userMO = mapper.aDb(user);
        userRepository.save(userMO);
    }

    @Override
    public void deleteById(String name) {
        userRepository.deleteById(name);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(mapper.aDb(user));
    }

}
