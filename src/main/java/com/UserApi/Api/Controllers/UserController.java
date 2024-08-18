package com.UserApi.Api.Controllers;

import com.UserApi.Api.Dtos.UserDTO;
import com.UserApi.Api.Entities.User;
import com.UserApi.Api.Services.Impl.UserServiceImpl;
import com.UserApi.Api.Services.UserService;
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
    @ResponseStatus(HttpStatus.OK)
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
}
