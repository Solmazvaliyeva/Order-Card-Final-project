package com.example.customerregistration.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name="users_roles")
@Immutable
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserRoleNEntity {

    @Id
    @Column(insertable = false ,updatable = false)
    private Integer id;

    @Column(name ="role_id" ,insertable = false ,updatable = false)
    private Integer roleId;

//    @ManyToOne
//    @JoinColumn(name = "role_id",insertable = false,updatable = false)
//    private Role roles;
}
