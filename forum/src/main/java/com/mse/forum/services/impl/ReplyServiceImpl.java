package com.mse.forum.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mse.forum.dto.ReplyDTO;
import com.mse.forum.mappers.ReplyMapper;
import com.mse.forum.persistance.ReplyRepository;
import com.mse.forum.persistance.entities.ReplyEntity;
import com.mse.forum.services.ReplyService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ReplyServiceImpl implements ReplyService {

	private ReplyMapper mapper;

	private ReplyRepository repository;

	@Override
	public boolean saveReply(ReplyDTO dto) {
		ReplyEntity entity = mapper.toEntity(dto);
		repository.save(entity);
		return true;
	}

	@Override
	public List<ReplyDTO> getAll() {
		return repository.findAll()
				.stream()
				.map(entity -> mapper.toDTO(entity))
				.collect(Collectors.toList());
	}

}
