package com.wzq.dao;

import com.wzq.pojo.User;
import com.wzq.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class UserDaoTest {

    @Test
    public void testGetUserList(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 方式一：使用多
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        AtomicInteger index=new AtomicInteger(0);
        userMapper.getUserList().stream().map(item -> index.getAndIncrement() + " : " + item).forEach(System.out::println);

        // 方式二：不推荐使用
//        List<User> userList = sqlSession.selectList("com.wzq.dao.UserMapper.getUserList");
//        userList.forEach(System.out::println);

        sqlSession.close();
    }

    @Test
    public void testGetUserListLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        String name = "%王";
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.getUserListLike(name).forEach(System.out::println);

        sqlSession.close();
    }

    @Test
    public void testGetUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 方式一：使用多
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.getUesrById(41));

        sqlSession.close();
    }

    // 增、删、改需要提交事务
    @Test
    public void testAddUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // add an user
        User user = new User(1, "alex", new Date(), '男', "上海");
        int rows = userMapper.addUser(user);

        // find an user
        User result = userMapper.getUesrById(1);

        // 提交事务
        sqlSession.commit();
        sqlSession.close();

        assertNotNull(result);
    }

    @Test
    public void testUpdateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // update an user
        User user = new User(1, "Alex_Wzq", new Date(), '男', "上海");
        int rows = userMapper.updateUser(user);

        // find an user
        User result = userMapper.getUesrById(1);

        // 提交事务
        sqlSession.commit();
        sqlSession.close();

        assertNotNull(result);
    }

    @Test
    public void testDeleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        int rows = userMapper.deleteUser(1);

        // find an user
        User result = userMapper.getUesrById(1);

        // 提交事务
        sqlSession.commit();
        sqlSession.close();

        assertNull(result);
    }
}
