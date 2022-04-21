package com;

import com.posts.PostService;
import com.users.UserService;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
    public UserService userService;
    public PostService postService;

    @BeforeMethod
    public void initialize() {
        userService = new UserService();
        postService = new PostService();
    }
}
