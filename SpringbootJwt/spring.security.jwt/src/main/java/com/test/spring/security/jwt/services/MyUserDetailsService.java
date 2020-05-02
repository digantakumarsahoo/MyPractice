package com.test.spring.security.jwt.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Service;

import com.test.spring.security.jwt.model.AuthenticationRequest;
import com.test.spring.security.jwt.model.DAOUser;
import com.test.spring.security.jwt.model.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DAOUser user = userDao.findByUsername(username);
		return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
	}
	public DAOUser save(AuthenticationRequest user) {
		DAOUser newUser = new DAOUser();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(new Pbkdf2PasswordEncoder().encode(user.getPassword()));
		return userDao.save(newUser);
	}

}
