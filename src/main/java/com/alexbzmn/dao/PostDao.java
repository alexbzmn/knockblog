package com.alexbzmn.dao;

import com.alexbzmn.Util;
import com.alexbzmn.model.Post;
import com.alexbzmn.model.Post.PostRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by User on 7/16/2017.
 */
public final class PostDao {

    public PostDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private JdbcTemplate jdbcTemplate;

    public List<Post> findByUserName(String userName) {
        String sql = "SELECT * FROM posts WHERE username = ?";
        return jdbcTemplate.query(sql, new Object[]{userName}, new PostRowMapper());
    }

    public int insert(Post post) {
        String sql = "INSERT INTO posts " +
                "(post_id, username, content, pub_date, name) VALUES (?, ?, ?, ?, ?)";


        return jdbcTemplate.update(sql,
                UUID.randomUUID().toString(),
                post.getUserName(),
                post.getContent(),
                Util.dateToStr(new Date()),
                post.getName());
    }
}
