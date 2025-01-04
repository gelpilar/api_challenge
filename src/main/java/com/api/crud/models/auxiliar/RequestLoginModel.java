package com.api.crud.models.auxiliar;

public class RequestLoginModel {

    public RequestLoginModel(String email, String contra) {
        this.email = email;
        this.contra = contra;
    }

    private  String email;
    private  String contra;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
}
