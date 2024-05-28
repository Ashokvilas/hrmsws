package com.hrms.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hrms.pojos.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    void deleteByUsername(String username);
    Optional<Users> findByUsername(String username);
}

