package com.alexbzmn.controller;

import com.alexbzmn.Util;
import com.alexbzmn.dao.PostDao;
import com.alexbzmn.model.Post;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by User on 7/15/2017.
 */
@Controller
@RequestMapping("/posts/")
public class PostController {

    @Autowired
    @Qualifier("postDao")
    private PostDao postDao;

    @RequestMapping(value = "{username}",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            method = RequestMethod.GET)
    @ResponseBody
    public String getPosts(
            @PathVariable("username") String userName) throws JsonProcessingException {

        List<Post> posts = postDao.findByUserName(userName);
        return Util.toJson(posts);
    }

    @RequestMapping(value = "post",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            method = RequestMethod.POST)
    @ResponseBody
    public int post(HttpServletRequest request, @RequestBody Post post) {
        String userName = request.getRemoteUser();
        if (!StringUtils.isEmpty(userName)) {
            post.setUserName(userName);
        }

        return postDao.insert(post);
    }

}
