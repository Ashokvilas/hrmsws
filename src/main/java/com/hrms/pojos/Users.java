package com.hrms.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor

@NoArgsConstructor
@Entity
@Table(name="users")
public class Users {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusers")
    private Integer idusers;
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "mobileno")
    private String mobileno;
    
    @Column(name = "employeecode")
    private String employeecode;
    
    @Column(name = "status")
    private String status;

	
}