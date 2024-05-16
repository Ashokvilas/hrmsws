package com.hrms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.services.UserService;
import com.hrms.pojos.Users;
import com.hrms.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserRepository userRepository;

	@Override
	public String upsert(Users users) {
		// TODO Auto-generated method stub
		userRepository.save(users);
		return "success";
	}

	@Override
	public List<Users> getAllUsers() {

		return userRepository.findAll();
	}

	@Override
	public String deleteUserById(Integer id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
		return "success";
	}

	@Override
	public Users getUserById(Integer userid) {
		// TODO Auto-generated method stub
		Optional<Users> findById = userRepository.findById(userid);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

}
