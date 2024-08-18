package com.UserApi.Api.Repositories;

import com.UserApi.Api.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByCpf(String cpf);
    Optional<User> findByEmail(String email);


}
