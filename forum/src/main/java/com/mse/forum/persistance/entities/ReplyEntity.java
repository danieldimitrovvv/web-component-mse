package com.mse.forum.persistance.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "topic", nullable =  false)
	private TopicEntity topic;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(nullable =  false)
	private UserEntity user;
	
	@Column(name = "created_on")
	private Date createdOn;
	
	@Column(name = "modified_on")
	private Date modifiedOn;
	
	@Column(name = "reply_content")
	private String replyContent;
	
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
