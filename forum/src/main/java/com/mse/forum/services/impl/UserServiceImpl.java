package com.mse.forum.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.hibernate.mapping.Collection;
import org.springframework.stereotype.Service;

import com.mse.forum.dto.UserDTO;
import com.mse.forum.mappers.UserMapper;
import com.mse.forum.persistance.UserRepository;
import com.mse.forum.persistance.entities.UserEntity;
import com.mse.forum.services.UserService;
import com.mse.forum.util.PasswordEncryptionUtil;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

	private UserMapper mapper;

	private UserRepository repository;

	@Override
	public boolean saveUser(UserDTO dto) {
		
		//dto.setPassword(PasswordEncryptionUtil.encrypt(dto.getPassword())) ;
		
		UserEntity entity = mapper.toEntity(dto);
		repository.save(entity);
		return true;
	}

	@Override
	public UserDTO getById(Long id) {
		return mapper.toDTO(repository.findById(id).get());
	}



	@Override
	public UserDTO getByName(String name) {
		Optional <UserEntity> userOptional = repository.getByName(name);
		return mapper.toDTO(userOptional.get());
	}

}
