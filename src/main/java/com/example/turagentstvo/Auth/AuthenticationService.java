package com.example.turagentstvo.Auth;

import com.example.turagentstvo.config.JwtService;
import com.example.turagentstvo.entities.Auth;
import com.example.turagentstvo.entities.Basket;
import com.example.turagentstvo.entities.Client;
import com.example.turagentstvo.entities.Role;
import com.example.turagentstvo.exceptions.UserAuthenticationException;
import com.example.turagentstvo.repositorys.AuthRepository;
import com.example.turagentstvo.repositorys.BasketRepository;
import com.example.turagentstvo.repositorys.ClientRepository;
import org.springframework.security.core.GrantedAuthority;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final SearchEngineUserRoleByUserAuthentication searchEngineUserRoleByUserAuthentication;
    private final ClientRepository clientRepository;
    private final AuthRepository authRepository;
    private final BasketRepository basketRepository;

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequestUser request) {


        if (authRepository.findByLogin(request.getAuth().getLogin()) != null)
            throw new UserAuthenticationException("Пользователь с таким логином уже существует");

        var userAuth = new Auth(
                request.getAuth().getLogin(),
                passwordEncoder.encode(request.getAuth().getPassword())
        );
        var basket = new Basket();
        var client = Client.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .patronymic(request.getPatronymic())
                .age(request.getAge())
                .passportId(request.getPassportId())
                .passportNumber(request.getPassportNumber())
                .authentication(userAuth)
                .basket(basket)
                .role(Role.CLIENT)
                .build();

        authRepository.save(userAuth);
        basketRepository.save(basket);
        clientRepository.save(client);

        var jwtToken = jwtService.generateToken(client, client.getRole());

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .user(client)
                .build();
    }

//    public AuthenticationResponse registerTransporter(RegisterRequestTransporter request) {
//
//
//        if (authRepository.findByLogin(request.getAuth().getLogin()) != null)
//            throw new UserAuthenticationException("Поставшик с таким логином уже существует");
//
//        var userAuth = new Auth(
//                request.getAuth().getLogin(),
//                passwordEncoder.encode(request.getAuth().getPassword())
//        );
//        var transporter = Transporter.builder()
//                .companyName(request.getCompanyName())
//                .logo(request.getLogo())
//                .phoneNumber(request.getPhoneNumber())
//                .authentication(userAuth)
//                .role(Role.TRANSPORTER)
//                .build();
//
//        authRepository.save(userAuth);
//        transporterRepository.save(transporter);
//
//        var jwtToken = jwtService.generateToken(transporter, transporter.getRole());
//
//        return AuthenticationResponse.builder()
//                .token(jwtToken)
//                .user(transporter)
//                .build();
//    }


    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getLogin(),
                        request.getPassword()
                )
        );
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;

            // Получение роли пользователя
            String role = userDetails.getAuthorities().stream()
                    .findFirst()
                    .map(GrantedAuthority::getAuthority)
                    .orElseThrow(() -> new UserAuthenticationException("У пользователя нет ролей"));

            String jwtToken;
            if (role.equals("CLIENT")) {
                jwtToken = jwtService.generateToken(userDetails, Role.CLIENT);
            } else if (role.equals("ADMIN")) {
                jwtToken = jwtService.generateToken(userDetails, Role.ADMIN);
            } else {
                throw new UserAuthenticationException("Недопустимая роль пользователя: " + role);
            }

            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .user(userDetails)
                    .build();
        } else {
            throw new UserAuthenticationException("Пользователь не найден");
        }
    }

}