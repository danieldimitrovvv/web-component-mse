package com.mse.forum.dto;

import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Pattern.Flag;

import org.hibernate.validator.constraints.UniqueElements;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

	// private Long replyId;

	private Long id;
	
	@UniqueElements
	private String name;

	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", flags = Flag.UNICODE_CASE)
	private String password;
	
	@Pattern(regexp = "/^(admin|user|moderator)$/", flags = Flag.UNICODE_CASE)
	private String rights;
}
