package com.mse.forum.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mse.forum.dto.TopicDTO;
import com.mse.forum.services.TopicService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/topics")
public class TopicsController {
	
	private TopicService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<TopicDTO> getAll() {
		return service.getAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, path="/{title}")
	public TopicDTO getByTitle(@PathVariable String title) {
		return service.getByTitle(title);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public void createTopic(@RequestBody TopicDTO topic) {
		service.saveTopic(topic);
		return;
	}
	
}
