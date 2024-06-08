package com.myapi.project.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private String name;
    private String username;
    private String email;
    private String password;
    private String telephone;

    public UserDto(String name, String username, String email, String password,  String telephone){
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.telephone = telephone;
    }
}
