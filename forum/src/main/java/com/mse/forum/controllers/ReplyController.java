package com.mse.forum.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mse.forum.dto.ReplyDTO;
import com.mse.forum.services.ReplyService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/replies")
public class ReplyController {
	
	private ReplyService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ReplyDTO> getAll() {
		return service.getAll();
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public void createTopic(@RequestBody ReplyDTO reply) {
		service.saveReply(reply);
		return;
	}
	
}
