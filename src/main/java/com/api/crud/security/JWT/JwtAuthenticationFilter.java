package com.api.crud.security.JWT;

import ch.qos.logback.core.util.StringUtil;
import com.api.crud.models.auxiliar.CostumerUserDetails;
import com.api.crud.services.security.JwtService;
import com.api.crud.services.security.UserDetailsCServices;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserDetailsCServices userDetailsCServices;

    public JwtAuthenticationFilter(JwtService jwtService, UserDetailsCServices userDetailsCServices) {
        this.jwtService = jwtService;
        this.userDetailsCServices = userDetailsCServices;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("d-1");

        final  String token = getTokenFromRequest(request);
       final  String username;

       if(token==null)
       {
           System.out.println("d0");

           filterChain.doFilter(request,response);
           return;
       }
        System.out.println("d-2");

       username = jwtService.getUsernameFromToken(token);

       System.out.println("d2"+username);
       if (username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
       {
           System.out.println("d3");
           UserDetails userDetails = userDetailsCServices.loadUserByUsername(username);
           System.out.println("d4");

           if(jwtService.isValidToken(token,userDetails))
           {           System.out.println("d5");

               UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
               System.out.println("d6");

               authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
               System.out.println("d7");

               SecurityContextHolder.getContext().setAuthentication(authToken);

               System.out.println("funcionaaaa");
           }
       }
        filterChain.doFilter(request,response);


    }

    private String getTokenFromRequest(HttpServletRequest request) {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (authHeader != null&&authHeader.startsWith("Bearer ")) {
            System.out.println("d8");
            return authHeader.substring(7);
        }
        System.out.println("Token no presente o no válido en el encabezado Authorization.");

        return null;
    }

}
