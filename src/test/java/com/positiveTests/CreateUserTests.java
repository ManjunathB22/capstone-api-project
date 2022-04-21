package com.positiveTests;

import com.BaseClass;
import com.users.request.CreateUserRequestBody;
import com.users.response.CreateUserResponseBody;
import org.testng.annotations.Test;

public class CreateUserTests extends BaseClass {

    @Test
    public void createUser() {
        //Arrange
        CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder().firstName("Elon").lastName("Musk").build();

        //Act
        CreateUserResponseBody responseBody = userService.createUser(requestBody);

        //Assert
        responseBody.assertCreatedUser(responseBody);
    }
}
