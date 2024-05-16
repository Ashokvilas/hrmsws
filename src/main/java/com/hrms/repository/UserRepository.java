package com.hrms.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hrms.pojos.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Serializable> {

	List<Users> findAll();
	
}
