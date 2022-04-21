package com.positiveTests;

import com.BaseClass;
import com.users.response.GetAllUsersInCurrentAccountResponseBody;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class GetAllUsersUnderCurrentAccoutTests extends BaseClass {

    @Test
    public void shouldGetAllUsersInCurrentAccount() {

        //Act
        GetAllUsersInCurrentAccountResponseBody accountResponseBody = userService.getCreatedUsers();

        //Assert
        assertEquals(accountResponseBody.getStatusCode(), 200);
    }
}
