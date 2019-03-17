package com.mse.forum.mappers;

import org.mapstruct.Mapper;

import com.mse.forum.dto.ReplyDTO;
import com.mse.forum.persistance.entities.ReplyEntity;

@Mapper(componentModel = "spring")
public interface ReplyMapper {

	ReplyEntity toEntity(ReplyDTO dto);
	
	ReplyDTO toDTO(ReplyEntity entity);
}
