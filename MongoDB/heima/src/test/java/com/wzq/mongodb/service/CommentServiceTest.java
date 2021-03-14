package com.wzq.mongodb.service;

import com.wzq.mongodb.pojo.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceTest {

    @Autowired
    private CommentService commentService;

    @Test
    public void testFindCommentList() {
        List<Comment> commentList = commentService.findCommentList();
        commentList.forEach(System.out::println);
    }

    @Test
    public void testFindCommentById() {
        Comment comment = commentService.findCommentById("1");
        System.out.println(comment);
    }

    @Test
    public void testfindByParentid() {
        Page<Comment> page = commentService.findByParentid("3", 1, 2);
        System.out.println(page.getTotalElements()); // 总条数
        System.out.println(page.getContent()); // list集合
    }

    @Test
    public void testfindByUserid() {
        Page<Comment> page = commentService.findByUserid("1003", 1, 2);
        System.out.println(page.getTotalElements()); // 总条数
        System.out.println(page.getContent()); // list集合
    }

    @Test
    public void testUpdateCommentLikenum() {
        commentService.updateCommentLikenum("1");
    }

}
