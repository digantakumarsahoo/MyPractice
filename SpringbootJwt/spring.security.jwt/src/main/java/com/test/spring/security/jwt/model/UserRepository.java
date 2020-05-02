package com.test.spring.security.jwt.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<DAOUser, String>{
	DAOUser findByUsername(String username);
}
