package com.users.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

@Getter
public class CreateUserErrorResponseBody {

    @Setter
    private int statusCode;

    @JsonProperty("data")
    private Data data;

    private String error;

    @Getter
    public static class Data {
        private String email;
    }


    public void assertExistingError() {
        Assert.assertEquals(getStatusCode(), 400);
        Assert.assertEquals(getError(), "BODY_NOT_VALID");
        Assert.assertEquals(data.getEmail(), "Email already used");
    }
}
