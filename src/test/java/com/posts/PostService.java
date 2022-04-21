package com.posts;

import com.posts.request.CreatePostRequestBody;
import com.posts.response.CreatePostResponseBody;
import com.posts.response.DeletePostResponseBody;
import io.restassured.response.Response;

public class PostService {

    public CreatePostResponseBody createPost(CreatePostRequestBody requestBody) {
        Response response = new PostClient().createPost(requestBody);
        CreatePostResponseBody createPostResponseBody = response.as(CreatePostResponseBody.class);
        createPostResponseBody.setStatusCode(response.getStatusCode());
        return createPostResponseBody;
    }

    public Post getPostByOwnerId(String postId) {
        Response response = new PostClient().getPostById(postId);
        response.then().log().body();
        Post post = response.as(Post.class);
        post.setStatusCode(response.getStatusCode());
        return post;
    }

    public DeletePostResponseBody deletePostById(String postId) {
        Response response = new PostClient().deletePost(postId);
        response.then().log().body();
        DeletePostResponseBody deletePost = response.as(DeletePostResponseBody.class);
        deletePost.setStatusCode(response.getStatusCode());
        return deletePost;
    }
}
