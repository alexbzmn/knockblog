package com.alexbzmn.dao;

import com.alexbzmn.model.Post;
import com.alexbzmn.model.Post.PostRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

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
}
