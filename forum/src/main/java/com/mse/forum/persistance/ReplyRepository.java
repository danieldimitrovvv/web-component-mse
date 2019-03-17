package com.mse.forum.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mse.forum.persistance.entities.ReplyEntity;

public interface ReplyRepository extends JpaRepository<ReplyEntity, Long>{

}
