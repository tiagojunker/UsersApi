package com.UserApi.Api.Controllers;

import com.UserApi.Api.Dtos.UpdateUserDTO;
import com.UserApi.Api.Dtos.UserDTO;
import com.UserApi.Api.Entities.User;
import com.UserApi.Api.Services.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserServiceImpl service;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody UserDTO userDTO) {
        return service.saveUser(userDTO);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserById(@PathVariable Integer id) {
        return service.getUserById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable Integer id){
        service.deleteUserById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Integer updateUser(@PathVariable Integer id, @RequestBody UpdateUserDTO updateUserDTO) {
        return service.updateUser(id, updateUserDTO);
    }
}
