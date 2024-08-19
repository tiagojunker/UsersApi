package com.UserApi.Api.Dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UpdateUserDTO {

    private String name;
    private String email;

}
