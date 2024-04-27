package com.example.turagentstvo.Auth;
import com.example.turagentstvo.entities.Auth;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestAdmin {
    private Auth auth;
}
