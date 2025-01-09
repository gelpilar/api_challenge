package com.api.crud.models.auxiliar;

public class TokenModel {
    private  String email;
    private  AuthResponse auth;

    public TokenModel(String email, AuthResponse auth) {
        this.email = email;
        this.auth = auth;
    }


}
