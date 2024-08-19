package com.UserApi.Api.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    @NotEmpty(message = "Name can't be empty!")
    private String name;

    @Column(unique = true, length = 11)
    @NotEmpty(message = "CPF can't be empty!")
    @CPF(message = "CPF must be valid!")
    private String cpf;

    @Column(unique = true)
    @NotEmpty(message = "Email can't be empty!")
    @Email(message = "Email must be valid!")
    private String email;

    @Column
    @NotNull(message = "Birth date can't be empty!")
    private LocalDate birthDate;

}
