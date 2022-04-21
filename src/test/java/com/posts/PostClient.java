package com.posts;

import com.posts.request.CreatePostRequestBody;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostClient {

    public Response createPost(CreatePostRequestBody body) {
        Response response =given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("app-id", "625edf72949fcfff0b244382")
                    .body(body)
                .when()
                    .post("https://dummyapi.io/data/v1/post/create");
        return response;
    }

    public Response getPostById(String postId) {
        return given()
                .header("app-id", "625edf72949fcfff0b244382")
                .when()
                .pathParam("post_id", postId)
                .get("https://dummyapi.io/data/v1/user/{post_id}/post?limit=10");
    }

    public Response deletePost(String postId) {
        return given()
                .header("app-id", "625edf72949fcfff0b244382")
                .when()
                .pathParam("post_id", postId)
                .delete("https://dummyapi.io/data/v1/post/{post_id}");
    }
}
