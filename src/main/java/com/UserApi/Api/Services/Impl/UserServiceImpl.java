package com.UserApi.Api.Services.Impl;

import com.UserApi.Api.Dtos.UserDTO;
import com.UserApi.Api.Entities.User;
import com.UserApi.Api.Exceptions.UserException;
import com.UserApi.Api.Repositories.UserRepository;
import com.UserApi.Api.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User saveUser(UserDTO user) {

        if(repository.findByCpf(user.getCpf()).isPresent()) {
            throw new UserException("Usuário com este CPF já existe!");
        }

        if(repository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserException("Usuário com este Email já existe!");
        }

        User userToSave = new User();

        userToSave.setName(user.getNome());
        userToSave.setCpf(user.getCpf());
        userToSave.setBirthDate(dateConverter(user.getDataNascimento()));
        userToSave.setEmail(user.getEmail());

        return repository.save(userToSave);
    }

    private LocalDate dateConverter(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate formatedDate = LocalDate.parse(date, formatter);
        return formatedDate;
    }
}
