package com.api.crud.services;

import com.api.crud.models.UserModel;
import com.api.crud.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    IUserRepository userRepository;

    public ArrayList<UserModel> getUsers()
    {
        return  (ArrayList<UserModel>)  userRepository.findAll();

    }


    public UserModel saveUser(UserModel user)
    {
        return  userRepository.save(user);
    }

    public Optional<UserModel> getById(Long id)
    {
     return  userRepository.findById(id);
    }

    public Optional<UserModel> login(String email,String contra)
    {
        return userRepository.encontrarPorEmailYContra(email,contra);
    }
}
