package com.mse.forum.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mse.forum.dto.UserDTO;

@Service
public interface UserService {

	boolean saveUser(UserDTO dto);
		
	UserDTO getByName(String name);

	UserDTO getById(Long id); 
}
