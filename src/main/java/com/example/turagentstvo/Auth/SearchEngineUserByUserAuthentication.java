package com.example.turagentstvo.Auth;
import com.example.turagentstvo.entities.Auth;

import java.util.Optional;
public interface SearchEngineUserByUserAuthentication<T> {
    Optional<T> findUserByUserAuthentication(Auth userAuth);
}
