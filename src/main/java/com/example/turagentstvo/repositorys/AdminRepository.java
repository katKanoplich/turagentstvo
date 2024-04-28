package com.example.turagentstvo.repositorys;

import com.example.turagentstvo.Auth.SearchEngineUserByUserAuthentication;
import com.example.turagentstvo.entities.Admin;
import com.example.turagentstvo.entities.Auth;
import com.example.turagentstvo.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>, SearchEngineUserByUserAuthentication<Admin> {

    Optional<Admin> findByAuthentication(Auth auth);
    default Optional<Admin> findUserByUserAuthentication(Auth userAuth) {
        return findByAuthentication(userAuth);
    }
}
