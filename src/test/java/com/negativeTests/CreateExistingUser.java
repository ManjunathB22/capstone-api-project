package com.negativeTests;

import com.BaseClass;
import com.users.request.CreateUserRequestBody;
import com.users.response.CreateUserErrorResponseBody;
import org.testng.annotations.Test;

public class CreateExistingUser extends BaseClass {

    @Test
    public void createUserWithExistingEmail() {

        //Arrange
        CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder().email("bill@gate1.com").build();

        //Act
        CreateUserErrorResponseBody responseBody = userService.createUserExpectingError(requestBody);

        //Assert
        responseBody.assertExistingError();
    }
}
