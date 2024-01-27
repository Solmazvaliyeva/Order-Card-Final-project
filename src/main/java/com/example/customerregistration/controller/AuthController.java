//package com.example.customerregistration.controller;
//
//
//
//import com.example.customerregistration.dao.UserEntity;
//import com.example.customerregistration.model.UserDto;
//import com.example.customerregistration.service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import java.util.List;
//
//@Controller
//@RequiredArgsConstructor
//public class AuthController {
//
//    private final UserService userService;
//
//
//    @GetMapping("/index")
//    public String home(){
//        return "index";
//    }
//
//    @GetMapping("/login")
//    public String login(){
//        return "login";
//    }
//
//
//    @GetMapping("/register")
//    public String showRegistrationForm(Model model){
//        // create model object to store form data
//        UserDto user = new UserDto();
//        model.addAttribute("user" ,user);
//        return "register";
//    }
//
//    @PostMapping("/register/save")
//    public String registration( @ModelAttribute("user") UserDto userDto,
//                               BindingResult result,
//                               Model model){
//        System.out.println(userDto);
//        UserEntity existingUser = userService.findUserByEmail(userDto.getEmail());
//
//        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
//            result.rejectValue("email", null,
//                    "There is already an account registered with the same email");
//        }
//
//        if(result.hasErrors()){
//            model.addAttribute("user", userDto);
//            return "/register";
//        }
//
//        userService.saveUser(userDto,false);
//        return "redirect:/register?success";
//    }
//
//    @GetMapping("/users")
//    public String users(Model model){
//        List<UserDto> users = userService.findAllUsers();
//        model.addAttribute("users", users);
//        System.out.println(users);
//        return "users";
//    }
//
//
//
//}
