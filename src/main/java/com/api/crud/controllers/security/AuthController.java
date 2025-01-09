package com.api.crud.controllers.security;

import com.api.crud.models.auxiliar.AuthResponse;
import com.api.crud.models.auxiliar.RegisterUserModel;
import com.api.crud.models.auxiliar.RequestLoginModel;
import com.api.crud.services.security.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/auth")

public class AuthController {


    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody RequestLoginModel request)
    {

        try {
            return ResponseEntity.ok(authService.login(request));
        }catch (Error e)
        {
            return ResponseEntity.badRequest().body(new AuthResponse("Error en el proceso de autenticación" + e.toString()));
        }



    }

    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@Valid  @RequestBody RegisterUserModel request)
    {
        return ResponseEntity.ok(authService.register(request));
    }

}
