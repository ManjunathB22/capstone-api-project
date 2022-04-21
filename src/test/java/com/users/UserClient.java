package com.users;

import com.users.request.CreateUserRequestBody;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {

    public Response getAllUsers() {
        Response response = given()
                .header("app-id", "625edf72949fcfff0b244382")
                .when()
                .get("https://dummyapi.io/data/v1/user?limit=10");
        response
                .then()
                .log().body();

        return response;
    }


    public Response createUser(CreateUserRequestBody body) {
        Response response =
                given()
                        .accept(ContentType.JSON)
                        .contentType(ContentType.JSON)
                        .header("app-id", "625edf72949fcfff0b244382")
                        .body(body)
                        .when()
                        .post("https://dummyapi.io/data/v1/user/create");
        return response;
    }


    public Response getUsersForCurrentAccount() {
        Response response = given()
                .header("app-id", "625edf72949fcfff0b244382")
                .when()
                .get("https://dummyapi.io/data/v1/user?created=1");
        return response;
    }
}
