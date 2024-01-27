//package com.example.customerregistration.service;
//
//
//
//import com.example.customerregistration.dao.Role;
//import com.example.customerregistration.dao.UserEntity;
//import com.example.customerregistration.dao.UserRoleNEntity;
//import com.example.customerregistration.model.UserDto;
//import com.example.customerregistration.repository.userrole.RoleRepository;
//import com.example.customerregistration.repository.userrole.UserRepository;
//import com.example.customerregistration.repository.userrole.UserRoleRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Arrays;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class LoginUserService {
//
//
//	private final UserRepository userRepository;
//
//	private final UserRoleRepository userRoleRepository;
//	private final RoleRepository roleRepository;
//
//
//	private final PasswordEncoder passwordEncoder;
//
//
//
//	public List<UserRoleNEntity>  getAllUsers() {
//		List<UserRoleNEntity> entities = userRoleRepository.findAdmin(2);
//		System.out.println(entities.size());
//		return entities;
//
//	}
//
//	public void addNew(UserDto userDto) {
//
//		UserEntity user = new UserEntity();
//		user.setFullName(userDto.getFirstName() + " " + userDto.getLastName());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
//		Role role = roleRepository.findByName("ADMIN");
//		user.setRoles(Arrays.asList(role));
//		userRepository.save(user);
//	}
//
//
//
//}
