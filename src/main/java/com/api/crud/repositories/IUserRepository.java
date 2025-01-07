package com.api.crud.repositories;

import com.api.crud.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<UserModel, Long> {

    @Query("SELECT u FROM UserModel u WHERE u.email = :email ")
    Optional<UserModel> encontrarPorEmailYContra(@Param("email") String email);

    @Query("SELECT u FROM UserModel u WHERE u.email = :email ")
    UserModel encontrarPorEmail(@Param("email") String email);
}
