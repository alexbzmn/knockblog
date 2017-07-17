package com.alexbzmn.dao;

import com.alexbzmn.AppConfig;
import com.alexbzmn.Util;
import com.alexbzmn.model.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by User on 7/17/2017.
 */
@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
public class PostDaoTest {
    @Autowired
    private PostDao postDao;

    @Test
    public void shouldReturnCorrectPostData() {
        String userName = "alex";
        List<Post> alexPosts = postDao.findByUserName(userName);

        assertTrue(alexPosts.size() > 0);

        Post firstPost = alexPosts.get(0);
        assertThat(firstPost.getUserName(), is(userName));
        assertThat(firstPost.getContent(), is("Test Content"));
        assertThat(firstPost.getName(), is("Sample Post"));
        assertThat(firstPost.getPubDate(), is(Util.strToDate("2017-07-16 00:00:00")));
    }
}
