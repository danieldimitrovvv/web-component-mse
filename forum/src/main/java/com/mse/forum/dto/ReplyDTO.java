package com.mse.forum.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReplyDTO {
	
	private String topicID;
	private String userID;
	private String text;
	private Date createdOn;
	private Date modifiedOn;
}
