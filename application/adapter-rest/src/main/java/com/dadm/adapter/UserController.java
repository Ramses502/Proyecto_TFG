package com.dadm.adapter;

import com.dadm.mapper.UserMapper;
import com.dadm.model.UserDto;
import com.dadm.ports.application.UserPort;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserMapper mapper = UserMapper.INSTANCE;
    private final UserPort userPort;

    @GetMapping("/all")
    public List<UserDto> getAll(){
       return userPort.get()
               .stream()
               .map(mapper::aDto)
               .collect(Collectors.toList());
    }

    @GetMapping
    public UserDto get(UserDto userDto) {
        return mapper.aDto(userPort.getUser(mapper.aDominio(userDto)));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/login")
    public UserDto login(@RequestParam String name, @RequestParam String password) {
        return mapper.aDto(userPort.login(name, password));
    }

    @GetMapping("/{name}")
    public UserDto getUser(String name) {
        return mapper.aDto(userPort.get(name));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/register")
    public void post(@RequestBody UserDto userDTO){
            userPort.createUser(mapper.aDominio(userDTO));
    }

    @PutMapping
    public void put(@RequestBody UserDto userDTO){
        userPort.updateUser(mapper.aDominio(userDTO));
    }

    @DeleteMapping
    public void delete(@RequestBody UserDto userDto){
        userPort.deleteUser(mapper.aDominio(userDto));
    }

    @DeleteMapping("/{name}")
    public void deleteById(@PathVariable String name) {
        userPort.deleteUserById(name);
    }
}
