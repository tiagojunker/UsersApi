package com.UserApi.Api.Dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserDTO {

    private String name;
    private String cpf;
    private String email;
    private String birthDate;

}
