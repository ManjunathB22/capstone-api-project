package com.users.response;

import lombok.Getter;
import lombok.Setter;

import static org.testng.Assert.*;

@Getter
public class CreateUserResponseBody {

    @Setter
    private int statusCode;

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String registerDate;
    private String updatedDate;

    public void assertCreatedUser(CreateUserResponseBody responseBody) {
        assertEquals(this.statusCode, 200);
        assertEquals(this.id, responseBody.id);
        assertEquals(this.firstName, responseBody.firstName);
        assertEquals(this.lastName, responseBody.lastName);
        assertEquals(this.email, responseBody.email);
        assertEquals(this.registerDate, responseBody.registerDate);
        assertEquals(this.updatedDate, responseBody.updatedDate);
    }
}
