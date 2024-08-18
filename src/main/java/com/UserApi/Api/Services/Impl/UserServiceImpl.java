package com.UserApi.Api.Services.Impl;

import com.UserApi.Api.Dtos.UserDTO;
import com.UserApi.Api.Entities.User;
import com.UserApi.Api.Exceptions.UserException;
import com.UserApi.Api.Repositories.UserRepository;
import com.UserApi.Api.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User saveUser(UserDTO user) {

        if(repository.findByCpf(user.getCpf()).isPresent()) {
            throw new UserException("Usuário com este CPF já existe!", HttpStatus.CONFLICT);
        }

        if(repository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserException("Usuário com este Email já existe!", HttpStatus.CONFLICT);
        }

        User userToSave = new User();

        userToSave.setName(user.getNome());
        userToSave.setCpf(user.getCpf());
        userToSave.setBirthDate(dateConverter(user.getDataNascimento()));
        userToSave.setEmail(user.getEmail());

        return repository.save(userToSave);
    }


    public List<User> getAllUsers() {
        return repository.findAll();
    }

    private LocalDate dateConverter(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate formatedDate = LocalDate.parse(date, formatter);
        return formatedDate;
    }

    public User getUserById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserException("Usuário com este Id Não Existe", HttpStatus.NOT_FOUND));
    }
}
