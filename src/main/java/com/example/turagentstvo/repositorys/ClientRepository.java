package com.example.turagentstvo.repositorys;

import com.example.turagentstvo.Auth.SearchEngineUserByUserAuthentication;
import com.example.turagentstvo.entities.Auth;
import com.example.turagentstvo.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> , SearchEngineUserByUserAuthentication<Client> {
    Optional<Client> findByAuthentication(Auth auth);
    default Optional<Client> findUserByUserAuthentication(Auth userAuth) {
        return findByAuthentication(userAuth);
    }

}
