package com.myapi.project.repository;

import com.myapi.project.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInterface extends JpaRepository<UserModel, Integer> {

    UserModel findByEmailIs(String email);

    public UserModel findByNameOrEmail(String nome, String email);
}
