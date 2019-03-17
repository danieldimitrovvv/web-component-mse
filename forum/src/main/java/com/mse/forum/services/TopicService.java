package com.mse.forum.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mse.forum.dto.TopicDTO;

@Service
public interface TopicService {

	boolean saveTopic(TopicDTO dto);
	
	List<TopicDTO> getAll(); 
		
	TopicDTO getByTitle(String title);

	TopicDTO getById(Long id); 
}
