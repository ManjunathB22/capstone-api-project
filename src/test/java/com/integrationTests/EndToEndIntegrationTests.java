package com.integrationTests;

import com.BaseClass;
import com.posts.Post;
import com.posts.PostService;
import com.posts.request.CreatePostRequestBody;
import com.posts.response.CreatePostResponseBody;
import com.posts.response.DeletePostResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;


public class EndToEndIntegrationTests extends BaseClass {
    @Test
    public void createUserAndDeleteUserAndUserDoNotExist() {
        //create post
        CreatePostRequestBody requestBody = new CreatePostRequestBody.Builder().build();
        CreatePostResponseBody responseBody = postService.createPost(requestBody);
        String postId = responseBody.getId();

        //Assert the post
        responseBody.assertCreatedPost(responseBody);

        //Delete the post by Id
        DeletePostResponseBody deletePostResponseBody = new PostService().deletePostById(postId);

        //Assert for non exsiting post
        Post post = new PostService().getPostByOwnerId(postId);
        Assert.assertEquals(post.getStatusCode(), 404);
    }
}
