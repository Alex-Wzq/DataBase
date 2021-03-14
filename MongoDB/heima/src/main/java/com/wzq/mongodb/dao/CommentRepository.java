package com.wzq.mongodb.dao;

import com.wzq.mongodb.pojo.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

// id是String
public interface CommentRepository extends MongoRepository<Comment, String> {

    Page<Comment> findByParentid(String parentid, Pageable pageable);

    Page<Comment> findByUserid(String Userid, Pageable pageable);

}
