package com.users;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
public class User {

    @Setter
    private int statusCode;

    @Getter
    private int total;
    private int page;
    private int limit;
    @JsonProperty("data")
    private List<Data> data;


    @Getter
    private static class Data {
        private String id;
        private String title;
        private String firstName;
        private String lastName;
        private String picture;
    }
}
