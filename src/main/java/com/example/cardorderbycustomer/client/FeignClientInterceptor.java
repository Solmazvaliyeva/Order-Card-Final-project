//package com.example.cardorderbycustomer.client;
//
//import com.example.cardorderbycustomer.auth.RegisterRequest;
//import com.example.cardorderbycustomer.security.JwtService;
//import com.example.cardorderbycustomer.user.User;
//import com.example.cardorderbycustomer.user.UserRepository;
//import feign.RequestInterceptor;
//import feign.RequestTemplate;
//import jakarta.servlet.http.HttpServletRequest;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//
//@Configuration
//@RequiredArgsConstructor
//public class FeignClientInterceptor implements RequestInterceptor {
//
//    private static final String AUTHORIZATION_HEADER = "Authorization";
//    private static final String TOKEN_TYPE = "Bearer";
//    private final JwtService jwtService;
//
//
//
//
//
//
//    @Override
//    public void apply(RequestTemplate requestTemplate) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println(authentication);
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//
//        if (authentication != null) {
//
//            String token = jwtService.generateToken(userDetails);
//
//            System.out.println(token);
//            requestTemplate.header(AUTHORIZATION_HEADER, String.format("%s %s", TOKEN_TYPE, token));
//        }
//    }
//
//
////    @Override
////    public void apply(RequestTemplate requestTemplate) {
////        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
////        System.out.println(authentication);
////
////        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
////
////        User user = repository.findByEmail(userDetails.getUsername()).orElseThrow();
////        RegisterRequest request = new RegisterRequest(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
////        cardAuthorize.register(request);
////    }
//
//}
