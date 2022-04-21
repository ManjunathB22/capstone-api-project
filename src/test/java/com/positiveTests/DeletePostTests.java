package com.positiveTests;

import com.posts.PostService;
import com.posts.request.CreatePostRequestBody;
import com.posts.response.CreatePostResponseBody;
import com.posts.response.DeletePostResponseBody;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DeletePostTests {

    @Test
    public void createAndDeletePostById() {
        //Arrange
        CreatePostRequestBody requestBody = new CreatePostRequestBody.Builder().build();
        CreatePostResponseBody createPostResponseBody = new PostService().createPost(requestBody);
        String postId = createPostResponseBody.getId();

        //Act
        DeletePostResponseBody deletePostResponseBody = new PostService().deletePostById(postId);

        //Assert
        assertEquals(deletePostResponseBody.getId(), postId);
        assertEquals(deletePostResponseBody.getStatusCode(), 200);
    }
}
