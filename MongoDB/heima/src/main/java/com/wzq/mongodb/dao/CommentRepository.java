package com.wzq.mongodb.dao;

import com.wzq.mongodb.pojo.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

// id是String
public interface CommentRepository extends MongoRepository<Comment, String> {
}
