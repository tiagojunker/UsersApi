package com.UserApi.Api.Services.Impl;

import com.UserApi.Api.Dtos.UpdateUserDTO;
import com.UserApi.Api.Dtos.UserDTO;
import com.UserApi.Api.Entities.User;
import com.UserApi.Api.Exceptions.UserException;
import com.UserApi.Api.Repositories.UserRepository;
import com.UserApi.Api.Services.UserService;
import com.UserApi.Api.Utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private DateUtils dateUtils;

    @Override
    public User saveUser(UserDTO user) {

        if(repository.findByCpf(user.getCpf()).isPresent()) {
            throw new UserException("Usuário com este CPF já existe!", HttpStatus.CONFLICT);
        }

        if(repository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserException("Usuário com este Email já existe!", HttpStatus.CONFLICT);
        }

        User userToSave = new User();

        userToSave.setName(user.getName());
        userToSave.setCpf(user.getCpf());
        userToSave.setBirthDate(dateUtils.dateConverter(user.getBirthDate()));
        userToSave.setEmail(user.getEmail());

        return repository.save(userToSave);
    }


    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUserById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserException("Usuário com este Id Não Existe", HttpStatus.NOT_FOUND));
    }

    public void deleteUserById(Integer id) {
        repository.deleteById(id);
    }

    public Integer updateUser(Integer id, UpdateUserDTO updateUserDTO) {

        User user = repository.findById(id)
                .orElseThrow(() -> new UserException("Usuário com este Id Não Existe", HttpStatus.NOT_FOUND));

        if(updateUserDTO.getEmail() == null) {
            throw new UserException("É necessário passar um email válido", HttpStatus.NOT_ACCEPTABLE);
        }

        if(updateUserDTO.getName() == null) {
            throw new UserException("É necessário passar um nome válido", HttpStatus.NOT_ACCEPTABLE);
        }

        user.setEmail(updateUserDTO.getEmail());
        user.setName(updateUserDTO.getName());

        return repository.save(user).getId();
    }
}
