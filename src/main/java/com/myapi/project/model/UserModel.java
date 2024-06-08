package com.myapi.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name="user")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @NotBlank(message = "Name is mandatory.")
    @Size(min = 3, message = "Name should have at least 3 characters")
    @Column(name="name", length = 200, nullable = false)
    private String name;

    @NotBlank(message = "Username is mandatory.")
    @Column(name="username", length = 100, nullable = false)
    private String username;

    @Email(message = "Insert a valid email.")
    @NotBlank(message = "Email is mandatory.")
    @Column(name="email", length = 50, nullable = false)
    private String email;

    @NotBlank(message = "Password is mandatory.")
    @Column(name="password", columnDefinition = "TEXT", nullable = false)
    private String password;

    @NotBlank(message = "Telephone is mandatory.")
    @Column(name="telephone", length = 15, nullable = false)
    private String telephone;

}
