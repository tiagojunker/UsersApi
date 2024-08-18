package com.UserApi.Api.Controllers;

import com.UserApi.Api.Dtos.UserDTO;
import com.UserApi.Api.Entities.User;
import com.UserApi.Api.Services.Impl.UserServiceImpl;
import com.UserApi.Api.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserServiceImpl service;

    @PostMapping()
    public User saveUser(@RequestBody UserDTO userDTO) {
        return service.saveUser(userDTO);
    }
}
