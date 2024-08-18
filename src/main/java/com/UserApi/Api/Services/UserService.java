package com.UserApi.Api.Services;

import com.UserApi.Api.Dtos.UserDTO;
import com.UserApi.Api.Entities.User;

import java.util.List;


public interface UserService {

    User saveUser(UserDTO user);
    List<User> getAllUsers();
    User getUserById(Integer id);

}
