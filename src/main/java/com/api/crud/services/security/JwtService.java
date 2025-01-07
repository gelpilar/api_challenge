package com.api.crud.services.security;

import com.api.crud.models.UserModel;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParserBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.*;
import java.util.function.Function;

@Service
public class JwtService {
    @Value("${token.signing.key}")
    private String jwtSigningKey;

    public  String getToken(UserModel user)
    {
        return getToken(new HashMap<>(),user);
    }
    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(jwtSigningKey.getBytes(StandardCharsets.UTF_8));
    }

    public String getUsernameFromToken(String token) {
        try {
            return getClaim(token, Claims::getSubject);
        } catch (Exception e) {
            System.out.println("Error al obtener el username del token: " + e.getMessage());
            return null;
        }
    }


    private  Date getExpiration(String token)
    {
        return  getClaim(token,Claims::getExpiration);
    }
    private  boolean isTokenExpired(String token)
    {
        return  getExpiration(token).before(new Date());
    }

    public boolean isValidToken(String token, UserDetails userDetails) {
        String username= getUsernameFromToken(token);
        return username != null && username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }


    private  Claims getAllClaims(String token)
    {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public  <T> T getClaim(String token, Function <Claims,T> claimsResolver)
    {
        final Claims claims=getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private String getToken(Map<String, Objects> extraClaims, UserModel user) {
        Key signingKey = getSigningKey();



        return Jwts.builder()
                .setSubject(user.getEmail())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(signingKey, SignatureAlgorithm.HS256)
                .compact();
    }

}
