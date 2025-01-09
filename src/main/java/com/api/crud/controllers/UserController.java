package com.api.crud.controllers;

import com.api.crud.models.UserModel;
import com.api.crud.models.auxiliar.RequestLoginModel;
import com.api.crud.models.auxiliar.UserAuxiliarModel;
import com.api.crud.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping
    public ArrayList<UserModel> getUsers(){

        return  this.userServices.getUsers();
    }

    @PostMapping("/auth/email")
    public  UserAuxiliarModel getUser(@RequestBody UserModel userConsulta)
    {

        UserModel usuario= this.userServices.getUserByEmailforlogin(userConsulta.getEmail());
        UserAuxiliarModel usuarioRta= new UserAuxiliarModel(usuario.getId(), usuario.getEmail(), usuario.getNombre());
        return usuarioRta;
    }
    @PostMapping
    public  UserModel saveModel(@RequestBody UserModel user)
    {

        return  this.userServices.saveUser(user);
    }


    @GetMapping(path="/{id}")
    public Optional<UserModel> getUserById(@PathVariable Long id){

        return  this.userServices.getById(id);
    }

}
