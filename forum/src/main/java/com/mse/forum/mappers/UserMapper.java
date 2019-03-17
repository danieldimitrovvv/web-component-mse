package com.mse.forum.mappers;

import org.mapstruct.Mapper;

import com.mse.forum.dto.UserDTO;
import com.mse.forum.persistance.entities.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {

	UserEntity toEntity(UserDTO dto);
	
	UserDTO toDTO(UserEntity entity);
}
