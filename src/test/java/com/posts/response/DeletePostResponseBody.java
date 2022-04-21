package com.posts.response;

import lombok.Getter;
import lombok.Setter;

@Getter
public class DeletePostResponseBody {
    public String id;

    @Setter
    private int statusCode;

}
