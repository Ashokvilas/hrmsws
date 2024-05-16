package com.hrms.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrms.pojos.Users;

@Service
public interface UserService {

	List<Users> getAllUsers();

	String upsert(Users users);

	Users getUserById(Integer userid);

	String deleteUserById(Integer userid);

}
