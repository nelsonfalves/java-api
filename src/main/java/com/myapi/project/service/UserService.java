package com.myapi.project.service;

import com.myapi.project.dto.UserDto;
import com.myapi.project.model.UserModel;
import com.myapi.project.repository.UserInterface;
import com.myapi.project.security.Token;
import com.myapi.project.security.TokenUtil;
import jakarta.validation.Valid;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserInterface repository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserInterface repository){
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<UserModel> getUsers(){
        return repository.findAll();
    }

    public Optional<UserModel> getUserById(Integer id){
        return repository.findById(id);
    }

    public void deleteUser (Integer id){
        repository.deleteById(id);
    }

    public UserModel createUser(UserModel user){
        String encoder = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(encoder);
        return repository.save(user);
    }

    public UserModel updateUser (UserModel user){
        String encoder = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(encoder);
        return repository.save(user);
    }


    public Token generateToken(@Valid UserDto userDto) {
        UserModel userModel = repository.findByNameOrEmail(userDto.getName(), userDto.getEmail());
        if (userModel != null) {
            boolean valid = passwordEncoder.matches(userDto.getPassword(), userModel.getPassword());

            if (valid) {
                return new Token(TokenUtil.createToken(userModel));
            }
        }
        return null;
    }
}
