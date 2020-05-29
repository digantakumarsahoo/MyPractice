package com.test.spring.security.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.spring.security.jwt.model.AuthenticationRequest;
import com.test.spring.security.jwt.model.AuthenticationResponse;
import com.test.spring.security.jwt.model.ChangePasswordRequest;
import com.test.spring.security.jwt.model.ChangePasswordResponse;
import com.test.spring.security.jwt.model.DAOUser;
import com.test.spring.security.jwt.model.OtpResponse;
import com.test.spring.security.jwt.services.MyUserDetailsService;
import com.test.spring.security.jwt.util.JwtUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")

public class UserResource {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService userDetailService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@RequestMapping(value="/about",method=RequestMethod.GET)
	public String about() {
		return "This project provides basic secuity credentials, you can register as a new user and create GWT token for furthur process of your"
				+ " request ";
	}
	@RequestMapping(value = "/authenticate",method =RequestMethod.POST)
	@ApiOperation(value = "Get GWT Token",response = AuthenticationResponse.class)
	@ApiImplicitParams({
			  @ApiImplicitParam(name = "Accept", value = "application/json", required = true,  paramType = "header", dataTypeClass = String.class, example = "application/json")
	})
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect Username or Password ",e);
		}
		
		final UserDetails userDetails = userDetailService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
		
	}
	@RequestMapping(value = "/register",method =RequestMethod.POST)
	@ApiOperation(value = "Register new user ")
	public ResponseEntity<?> registerUser(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		try {
			DAOUser daoUser=userDetailService.save(authenticationRequest);
			return ResponseEntity.ok(daoUser);
		} catch (BadCredentialsException e) {
			throw new Exception("Unable to Register user ",e);
		}
		
		
	}
	
	@ApiImplicitParams({
		  @ApiImplicitParam(name = "Authorization", value = "GWT Token", required = true,  paramType = "header", dataTypeClass = String.class, example = "dsflkjldkfjs")
})
	@RequestMapping(value = "/demo",method =RequestMethod.GET)
	public ResponseEntity<?> demoUser() throws Exception {
		try {
			return ResponseEntity.ok("DEmo...");
		} catch (BadCredentialsException e) {
			throw new Exception("Unable to Register user ",e);
		}
		
		
	}
	
	@RequestMapping(value = "/changepassword",method =RequestMethod.PUT)
	@ApiOperation(value = "Change user password ")
	public ResponseEntity<ChangePasswordResponse> changePassword(@RequestBody ChangePasswordRequest changePasswordRequest) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(changePasswordRequest.getUserName(), changePasswordRequest.getCurrentPassword()));
			ChangePasswordResponse response=userDetailService.updatePassword(changePasswordRequest);
			return ResponseEntity.ok(response);
		} catch (BadCredentialsException e) {
			throw new Exception("Current Password is wrong ",e);
		}
		
		
	}
	@RequestMapping(value = "/forgotpassword",method =RequestMethod.GET)
	@ApiOperation(value = "forgot user password ")
	public ResponseEntity<OtpResponse> forgotPassword(@RequestParam String emailId) throws Exception {
			return ResponseEntity.ok(userDetailService.sendOtpForgotPassword(emailId));
	
	}	
}
