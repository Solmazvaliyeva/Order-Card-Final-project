//package com.example.customerregistration.repository.userrole;
//
//import com.example.customerregistration.dao.UserRoleNEntity;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import java.util.List;
//
//public interface UserRoleRepository extends JpaRepository<UserRoleNEntity,Integer> {
//
//
//    @Query("select c from UserRoleNEntity c where c.roleId = :id")
//    List<UserRoleNEntity> findAdmin(Integer id);
//
//}
