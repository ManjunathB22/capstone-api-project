package com.users;

import com.users.request.CreateUserRequestBody;
import com.users.response.CreateUserErrorResponseBody;
import com.users.response.CreateUserResponseBody;
import com.users.response.GetAllUsersInCurrentAccountResponseBody;
import io.restassured.response.Response;

public class UserService {

    public User getAllUserList() {
        Response response = new UserClient().getAllUsers();
        User user = response.as(User.class);
        user.setStatusCode(response.statusCode());
        return user;
    }

    public CreateUserResponseBody createUser(CreateUserRequestBody requestBody) {
        Response response = new UserClient().createUser(requestBody);
        CreateUserResponseBody createUserResponseBody = response.as(CreateUserResponseBody.class);
        createUserResponseBody.setStatusCode(response.statusCode());
        return createUserResponseBody;
    }

    public CreateUserErrorResponseBody createUserExpectingError(CreateUserRequestBody requestBody) {
        Response response = new UserClient().createUser(requestBody);
        CreateUserErrorResponseBody createUserErrorResponseBody = response.as(CreateUserErrorResponseBody.class);
        createUserErrorResponseBody.setStatusCode(response.getStatusCode());
        response.then().log().body();
        return createUserErrorResponseBody;
    }

    public GetAllUsersInCurrentAccountResponseBody getCreatedUsers() {
        Response response = new UserClient().getUsersForCurrentAccount();
        response.then().log().body();
        GetAllUsersInCurrentAccountResponseBody currentAccountResponseBody = response.as(GetAllUsersInCurrentAccountResponseBody.class);
        currentAccountResponseBody.setStatusCode(response.getStatusCode());
        return currentAccountResponseBody;
    }
}
