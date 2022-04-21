package com.positiveTests;

import com.BaseClass;
import com.posts.request.CreatePostRequestBody;
import com.posts.response.CreatePostResponseBody;
import org.testng.annotations.Test;

public class CreatePostTests extends BaseClass {

    @Test
    public void createPost() {
        //Arrange
        CreatePostRequestBody requestBody = new CreatePostRequestBody.Builder().build();

        //Act
        CreatePostResponseBody responseBody = postService.createPost(requestBody);

        //Assert
        responseBody.assertCreatedPost(responseBody);
    }
}
