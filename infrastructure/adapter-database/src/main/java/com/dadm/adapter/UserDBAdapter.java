package com.dadm.adapter;

import com.dadm.mapper.*;
import com.dadm.model.*;
import com.dadm.ports.infrastructure.UserDBPort;
import com.dadm.repositories.UserRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class UserDBAdapter implements UserDBPort {

    private final UserMapper mapper = UserMapper.INSTANCE;
    private final UserNoGroupsNoExpensesMapper noGroupsNoExpensesMapper = UserNoGroupsNoExpensesMapper.INSTANCE;

    private final UserRepository userRepository;

    public UserDBAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> get() {
        return userRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public User get(String name) {
        UserMO userMO = userRepository.getOne(name);
        return mapper.toDomain(userMO);
    }

    @Override
    public void upload(User user) {
        UserMO userMO = mapper.toMO(user);
        userRepository.save(userMO);
    }

    @Override
    public void update(User user) {
        UserMO userMO = mapper.toMO(user);
        userRepository.save(userMO);
    }

    @Override
    public void delete(String name) {
        userRepository.deleteById(name);
    }

}
