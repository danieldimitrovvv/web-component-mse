package com.mse.forum.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mse.forum.dto.ReplyDTO;

@Service
public interface ReplyService {

	boolean saveReply(ReplyDTO dto);
	
	List<ReplyDTO> getAll(); 
		
}
