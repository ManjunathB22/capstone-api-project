package com.posts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Post {
    @Setter
    private int statusCode;

    private String total;
    private List<Data> data;
    private String limit;
    private String page;

    @Getter
    public static class Data {
        private Owner owner;
        private String image;
        private String publishDate;
        private String id;
        private String text;
        private String updatedDate;
        private String likes;
        private List<String> tags;
    }

    @Getter
    public static class Owner {
        private String firstName;
        private String lastName;
        private String id;
        private String title;
        private String picture;
    }


    public void assertPostResponse(String postId) {
        Assert.assertEquals(getStatusCode(), 200);
        Assert.assertEquals(getData().stream()
                        .filter(data1 -> data1.getOwner().id.equalsIgnoreCase(postId)).collect(Collectors.toList()).size()
                , 10);
    }
}
