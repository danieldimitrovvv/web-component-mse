package com.mse.forum.services.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mse.forum.dto.ReplyDTO;
import com.mse.forum.mappers.ReplyMapper;
import com.mse.forum.persistance.ReplyRepository;
import com.mse.forum.persistance.TopicRepository;
import com.mse.forum.persistance.UserRepository;
import com.mse.forum.persistance.entities.ReplyEntity;
import com.mse.forum.persistance.entities.TopicEntity;
import com.mse.forum.persistance.entities.UserEntity;
import com.mse.forum.services.ReplyService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService {

	private ReplyMapper mapper;

	private TopicRepository topicRepository;
	private UserRepository userRepository;
	private ReplyRepository replyRepository;

	@Override
	public boolean saveReply(ReplyDTO dto) {
		Optional<TopicEntity> findTopic = topicRepository.findById(dto.getTopicId());
		Optional<UserEntity> findUser = userRepository.findById(dto.getUserId());
		
		if(!findTopic.isPresent()) {
			throw new IllegalArgumentException("Tryed to add a reply to non-exist topic.");
		}
		
		if(!findUser.isPresent()) {
			throw new IllegalArgumentException("Tryed to add a reply to non-exist user.");
		}
		
		ReplyEntity entity = mapper.toEntity(dto);
		entity.setTopic(findTopic.get());
		entity.setUser(findUser.get());
		replyRepository.save(entity);
		return true;
	}

	@Override
	public List<ReplyDTO> getAll() {
		return replyRepository.findAll()
				.stream()
				.map(entity -> mapper.toDTO(entity))
				.collect(Collectors.toList());
	}

	@Override
	public List<ReplyDTO> getByTopicId(Long topicId) {
		Optional<TopicEntity> topic = topicRepository.findById(topicId);
		
		if(!topic.isPresent()) {
			throw new IllegalArgumentException("Tryed to add a reply to non-exist topic.");
		}
		
		return topic.get()
				.getReplies()
				.stream()
				.map(replay -> mapper.toDTO(replay))
				//.map(mapper::toDTO)
				.collect(Collectors.toList());
	}
	
	
	@Override
	public List<ReplyDTO> getByUserId(Long UserId) {
		Optional<UserEntity> user = userRepository.findById(UserId);
		
		if(!user.isPresent()) {
			throw new IllegalArgumentException("Tryed to add a reply to non-exist topic.");
		}
		
		return user.get()
				.getReplies()
				.stream()
				.map(replay -> mapper.toDTO(replay))
				//.map(mapper::toDTO)
				.collect(Collectors.toList());
	}

}
