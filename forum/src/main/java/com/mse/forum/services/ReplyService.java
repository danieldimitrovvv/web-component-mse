package com.mse.forum.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mse.forum.dto.ReplyDTO;

@Service
public interface ReplyService {

	boolean saveReply(ReplyDTO dto);
	
	List<ReplyDTO> getByTopicId(Long topicId); 

	List<ReplyDTO> getByUserId(Long UserId); 
	
	List<ReplyDTO> getAll(); 
		
}
