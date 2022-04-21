package com.positiveTests;

import com.posts.Post;
import com.posts.PostService;
import com.posts.request.CreatePostRequestBody;
import com.posts.response.CreatePostResponseBody;
import org.testng.annotations.Test;

public class GetPostTests {

    @Test
    public void createAndGetPostByOwnerId(){
        //Arrange
        CreatePostRequestBody requestBody = new CreatePostRequestBody.Builder().build();
        CreatePostResponseBody createPostResponseBody = new PostService().createPost(requestBody);
        String ownerId = createPostResponseBody.getOwner().getId();

        //Act
        Post post = new PostService().getPostByOwnerId(ownerId);

        //Assert
        post.assertPostResponse(ownerId);
    }
}
