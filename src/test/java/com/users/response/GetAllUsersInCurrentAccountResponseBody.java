package com.users.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class GetAllUsersInCurrentAccountResponseBody {

    @Setter
    private int statusCode;

    private int total;
    private int limit;
    private int page;
    private List<Data> data;

    @Getter
    public static class Data {
        private String firstName;
        private String lastName;
        private String id;
    }
}
