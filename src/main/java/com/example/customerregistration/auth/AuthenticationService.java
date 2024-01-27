package com.example.customerregistration.auth;


import com.example.customerregistration.securityconfig.JwtService;
import com.example.customerregistration.user.Role;
import com.example.customerregistration.user.User;
import com.example.customerregistration.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request){
        var user=  User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request){
        System.out.println(request);


        UsernamePasswordAuthenticationToken token=
                new UsernamePasswordAuthenticationToken(request.getEmail() ,request.getPassword());
        System.out.println("token " + token);
//        var entity = authenticationManager.authenticate(
//                token);
//        System.out.println("userauth +" +entity.isAuthenticated() );
        var user = repository.findByEmail(request.getEmail()).orElseThrow();
        System.out.println("user +" + user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();

    }
}
