package com.mse.forum.services.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mse.forum.persistance.UserRepository;
import com.mse.forum.persistance.entities.Roles;
import com.mse.forum.persistance.entities.UserEntity;

import lombok.AllArgsConstructor;

@Service
@Configuration
@AllArgsConstructor
public class UserDetailsServiceImp implements UserDetailsService{

	UserRepository usersRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = usersRepository.getByName(username)
				.orElseThrow(() -> new IllegalArgumentException());
		
		return User.builder()
				.username(user.getName())
				.password(passwordEncoder().encode(user.getPassword()))
				.roles("ADMIN")
				.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
