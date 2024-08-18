package com.UserApi.Api.Services;

import com.UserApi.Api.Dtos.UserDTO;
import com.UserApi.Api.Entities.User;


public interface UserService {

    User saveUser(UserDTO user);

}
