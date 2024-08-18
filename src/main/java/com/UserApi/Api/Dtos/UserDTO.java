package com.UserApi.Api.Dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserDTO {

    private String nome;
    private String cpf;
    private String email;
    private String dataNascimento;

}
