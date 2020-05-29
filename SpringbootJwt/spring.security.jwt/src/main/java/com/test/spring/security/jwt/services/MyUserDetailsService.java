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
import com.test.spring.security.jwt.model.ChangePasswordRequest;
import com.test.spring.security.jwt.model.ChangePasswordResponse;
import com.test.spring.security.jwt.model.DAOUser;
import com.test.spring.security.jwt.model.OtpResponse;
import com.test.spring.security.jwt.model.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userDao;
	
	@Autowired
	private EmailService emailService;

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
	
	public ChangePasswordResponse updatePassword(ChangePasswordRequest changePasswordRequest)
	{
		DAOUser user = userDao.findByUsername(changePasswordRequest.getUserName());
		if(user == null)
			throw new RuntimeException("Invalid User Name ");
		if(!changePasswordRequest.getNewPassword().equals(changePasswordRequest.getConfirmPassword()))
			throw new RuntimeException("Both new password and confirm password are not matching");
		
		user.setPassword(new Pbkdf2PasswordEncoder().encode(changePasswordRequest.getNewPassword()));
		userDao.save(user);
		
		return new ChangePasswordResponse(true,"Password Changed Successfully");
	}
	
	public OtpResponse sendOtpForgotPassword(String emailId) {
		emailService.sendEmail(emailId, "1234");
		OtpResponse otpResponse = new OtpResponse();
		otpResponse.setOtp("1234");
		otpResponse.setRefId("1234");
		return otpResponse;
	}

}
