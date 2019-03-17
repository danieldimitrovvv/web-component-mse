package com.mse.forum.persistance.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity(name = "users")
public class UserEntity {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique = true)
	private String name;
	
	private String password;
	
	private String rights;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<ReplyEntity> replies;
	
}
