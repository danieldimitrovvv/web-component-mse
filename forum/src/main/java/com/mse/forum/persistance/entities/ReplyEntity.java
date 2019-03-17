package com.mse.forum.persistance.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity(name = "replies")
public class ReplyEntity {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name = "topic_id")
	private String topicID;
	
	@Column(name = "user_id")
	private String userID;
	
	@Column(name = "created_on")
	private Date createdOn;
	
	@Column(name = "modified_on")
	private Date modifiedOn;
	
	private String text;
	
	@PrePersist
	public void setDates() {
		this.createdOn = new Date();
		this.modifiedOn = new Date();
	}
	
	@PreUpdate
	public void updateDates() {
		this.modifiedOn = new Date();
	}
}
