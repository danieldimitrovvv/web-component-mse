package com.mse.forum.services.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.hibernate.mapping.Collection;
import org.springframework.stereotype.Service;

import com.mse.forum.dto.TopicDTO;
import com.mse.forum.mappers.TopicMapper;
import com.mse.forum.persistance.TopicRepository;
import com.mse.forum.persistance.entities.TopicEntity;
import com.mse.forum.services.TopicService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TopicServiceImpl implements TopicService {

	private TopicMapper mapper;

	private TopicRepository repository;

	@Override
	public boolean saveTopic(TopicDTO dto) {
		TopicEntity entity = mapper.toEntity(dto);
		repository.save(entity);
		return true;
	}

	@Override
	public List<TopicDTO> getAll() {
		return repository.findAll()
				.stream()
				.map(entity -> mapper.toDTO(entity))
				.collect(Collectors.toList());
	}

	@Override
	public TopicDTO getByTitle(String title) {
		return mapper.toDTO(repository.getByTitle(title));
	}

}
