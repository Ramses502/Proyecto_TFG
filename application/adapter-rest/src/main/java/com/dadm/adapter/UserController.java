package com.dadm.adapter;

import com.dadm.mapper.UserRestMapper;
import com.dadm.model.UserDTO;
import com.dadm.ports.application.UserPort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRestMapper mapper = UserRestMapper.INSTANCE;

    private final UserPort userPort;

    public UserController(UserPort userPort) {
        this.userPort = userPort;
    }
    @GetMapping("/all")
    public List<UserDTO> getAll(){
       return userPort.get()
               .stream()
               .map(mapper::toDTO)
               .collect(Collectors.toList());
    }


    @PostMapping("/register")
    public void post(@RequestBody UserDTO userDTO){
            userPort.createUser(mapper.toDomain(userDTO));
    }

    @PutMapping
    public void put(@RequestBody UserDTO userDTO){
        userPort.updateUser(mapper.toDomain(userDTO));
    }

    @DeleteMapping
    public void delete(@RequestParam String name){
        userPort.deleteUser(name);
    }
}
