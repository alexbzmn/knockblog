package com.alexbzmn.model;

import com.alexbzmn.Util;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by User on 7/16/2017.
 */
public class Post {

    private Integer id;
    private String name;
    private String content;
    private Date pubDate;
    private String userName;


    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static class PostRowMapper implements RowMapper<Post> {

        public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
            Post post = new Post();

            post.setContent(rs.getString("content"));
            post.setId(rs.getInt("post_id"));
            post.setName(rs.getString("name"));
            post.setUserName(rs.getString("username"));

            String pubDate = rs.getString("pub_date");
            post.setPubDate(Util.strToDate(pubDate));

            return post;
        }

    }
}
