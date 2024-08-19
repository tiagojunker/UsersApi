package com.UserApi.Api.Services;

import com.UserApi.Api.Dtos.UpdateUserDTO;
import com.UserApi.Api.Dtos.UserDTO;
import com.UserApi.Api.Entities.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface UserService {

    User saveUser(UserDTO user);
    List<User> getAllUsers();
    User getUserById(Integer id);
    void deleteUserById(Integer id);
    Integer updateUser(Integer id, UpdateUserDTO updateUserDTO);

}
