package com.positiveTests;

import com.users.User;
import com.users.UserService;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class GetAllUsersTests {

    @Test
    public void getAllUsersList() {

        //Act
        User user = new UserService().getAllUserList();

        //Assert
        assertEquals(user.getStatusCode(), 200);
    }
}
