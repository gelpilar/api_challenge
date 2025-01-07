package com.api.crud.services.security;

import com.api.crud.models.UserModel;
import com.api.crud.models.auxiliar.AuthResponse;
import com.api.crud.models.auxiliar.CostumerUserDetails;
import com.api.crud.models.auxiliar.RegisterUserModel;
import com.api.crud.models.auxiliar.RequestLoginModel;
import com.api.crud.services.UserServices;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthService {
    private final UserServices userServices;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private  final UserDetailsCServices userDetailsCServices;

    public AuthService(UserServices userServices, JwtService jwtService, AuthenticationManager authenticationManager, UserDetailsCServices userDetailsCServices) {
        this.userServices = userServices;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.userDetailsCServices = userDetailsCServices;
    }

    public AuthResponse login(RequestLoginModel request) {
        try {
            System.out.println("Iniciando autenticación para el email: " + request.getEmail());

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getContra())
            );
            UserModel user= new UserModel();
            user.setEmail(request.getEmail());
            user.setContra(request.getContra());

            String token = jwtService.getToken(user);
            return new AuthResponse(token);
        } catch (BadCredentialsException e) {
            System.out.println("Credenciales inválidas para el email: " + request.getEmail());
            throw new RuntimeException("Credenciales inválidas");
        } catch (UsernameNotFoundException e) {
            System.out.println("Usuario no encontrado: " + request.getEmail());
            throw new RuntimeException("Usuario no encontrado");
        } catch (Exception e) {
            System.out.println("Error en el proceso de autenticación para el email: " + request.getEmail() + ". Error: " + e.getMessage());
            throw new RuntimeException("Error en el proceso de autenticación", e);
        }
    }



    public AuthResponse register(RegisterUserModel request) {

        UserModel user = new UserModel();
        user.setContra(passwordEncoder().encode(request.getContra()));
        user.setEmail(request.getEmail());
        user.setNombre(request.getNombre());

        userServices.saveUser(user);

        String token = jwtService.getToken(user);

        AuthResponse authResponse = new AuthResponse(token);

        return authResponse;
    }


    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
