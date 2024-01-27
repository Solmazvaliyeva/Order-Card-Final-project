//package com.example.customerregistration.service.impl;
//
//import com.example.customerregistration.dao.Role;
//import com.example.customerregistration.dao.UserEntity;
//import com.example.customerregistration.model.UserDto;
//import com.example.customerregistration.repository.userrole.RoleRepository;
//import com.example.customerregistration.repository.userrole.UserRepository;
//import com.example.customerregistration.service.UserService;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class UserServiceImpl implements UserService {
//
//    private final UserRepository userRepository;
//    private final RoleRepository roleRepository;
//    private final PasswordEncoder passwordEncoder;
//    @Override
//    public void saveUser(UserDto userDto  , Boolean roleAdmin) {
//        String roleOfUser = "ROLE_ADMIN";
//        UserEntity user = new UserEntity();
//        user.setFullName(userDto.getFirstName() + " " + userDto.getLastName());
//        user.setEmail(userDto.getEmail());
//
//        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
//
//        if (roleAdmin == Boolean.TRUE){
//            roleOfUser = "ADMIN";
//        }
//
//        Role role = roleRepository.findByName(roleOfUser);
//        if(role == null){
//            role = checkRoleExist(roleOfUser);
//        }
//
//        user.setRoles(Arrays.asList(role));
//        userRepository.save(user);
//    }
//
//
//
//    private Role checkRoleExist(String roleOfUser){
//        Role role = new Role();
//        role.setName(roleOfUser);
//        return roleRepository.save(role);
//    }
//
//    @Override
//    public UserEntity findUserByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }
//
//    @Override
//    public List<UserDto> findAllUsers() {
//        List<UserEntity> users = userRepository.findAll();
//        return users.stream()
//                .map((user) -> mapToUserDto(user))
//                .collect(Collectors.toList());
//    }
//
//    private UserDto mapToUserDto(UserEntity user){
//        UserDto userDto = new UserDto();
//        String[] str = user.getFullName().split(" ");
//        userDto.setFirstName(str[0]);
//        userDto.setLastName(str[1]);
//        userDto.setEmail(user.getEmail());
//        return userDto;
//    }
//}
