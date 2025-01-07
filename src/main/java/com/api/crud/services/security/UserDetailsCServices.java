package com.api.crud.services.security;

import com.api.crud.models.UserModel;
import com.api.crud.models.auxiliar.CostumerUserDetails;
import com.api.crud.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsCServices implements UserDetailsService {
    private final UserServices userServices;

    public UserDetailsCServices(UserServices userServices) {
        this.userServices = userServices;
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException  {

        try {
            UserModel user = userServices.getUserByEmailforlogin(username);

            return new CostumerUserDetails(user);

        } catch (UsernameNotFoundException e) {
            System.out.println("Error al cargar usuario: " + e.getMessage());
            throw e;

        } catch (Exception e) {
            System.out.println("Error inesperado al cargar usuario: " + e.getMessage());
            throw new RuntimeException("Error en la carga del usuario: " + e.getMessage());
        }

    }

    public UserModel loadUser(String email)
    {
       CostumerUserDetails costumerUserDetails= (CostumerUserDetails)loadUserByUsername(email);
       return (UserModel) costumerUserDetails.getUser();
    }

}
