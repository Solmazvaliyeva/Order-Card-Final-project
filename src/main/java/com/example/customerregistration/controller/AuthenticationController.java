package com.example.customerregistration.controller;


import com.example.customerregistration.auth.AuthenticationRequest;
import com.example.customerregistration.auth.AuthenticationResponse;
import com.example.customerregistration.auth.AuthenticationService;
import com.example.customerregistration.auth.RegisterRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
//@SecurityRequirement(name = "bearerAuth")
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(service.register(request));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success Authentication",
                    content = { @Content }),
            @ApiResponse(responseCode = "400", description = "Failed Authentication",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Failed Authentication",
                    content = @Content) })
    @PostMapping("/authenticate")
    @Operation(summary = "My endpoint", security = @SecurityRequirement(name = "bearerAuth"))

    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(service.authenticate(request));


    }
}
