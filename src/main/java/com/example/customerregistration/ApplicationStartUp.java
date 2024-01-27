//package com.example.customerregistration;
//
//
//import com.example.customerregistration.model.UserDto;
//import com.example.customerregistration.service.LoginUserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.ApplicationListener;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//public class ApplicationStartUp implements ApplicationListener<ApplicationReadyEvent> {
//
//
//    private  final LoginUserService userService;
//
//    @Override
//    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
//        initDatabaseEntities();
//    }
//
//
//    private void initDatabaseEntities() {
//        System.out.println("bura geldim");
//        if( userService.getAllUsers().size() == 0) {
//            userService.addNew(new UserDto(null ,"Admin", "Admin", "admin@gmail.com", "admin"));
//            System.out.println("bura da geldim");
//        }
//
//    }
//}
