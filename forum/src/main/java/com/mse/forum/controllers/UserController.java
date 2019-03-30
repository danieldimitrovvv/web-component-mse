package com.mse.forum.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mse.forum.dto.UserDTO;
import com.mse.forum.services.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/users")
public class UserController {
	
	private UserService service;
	
	
	@RequestMapping(method = RequestMethod.GET, path="/name/{name}")
	public UserDTO getByName(@PathVariable String name) {
		return service.getByName(name);
	}
	
	@RequestMapping(method = RequestMethod.GET, path="/id/{id}")
	public UserDTO getById(@PathVariable Long id) {
		return service.getById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<String> createUser(@RequestBody UserDTO user) {
		service.saveUser(user);
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(new String("created"), HttpStatus.OK);
		return responseEntity;
	}
	
}
