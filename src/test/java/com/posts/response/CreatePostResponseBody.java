package com.posts.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static org.testng.Assert.*;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatePostResponseBody {

    private String id;
    private Owner owner;
    private String image;
    private String link;
    private String publishDate;
    private String text;
    private String updatedDate;
    private int likes;
    private List<String> tags;

    @Setter
    private int statusCode;

    @Getter
    public static class Owner {
        private String id;
        private String firstName;
        private String lastName;
        private String title;
        private String picture;
    }

    public void assertCreatedPost(CreatePostResponseBody requestBody) {
        assertEquals(this.getStatusCode(), 200);
        assertEquals(this.getImage(), requestBody.getImage());
        assertEquals(this.getLikes(), requestBody.getLikes());
        assertEquals(this.getTags(), requestBody.getTags());
        assertEquals(this.getText(), requestBody.getText());
    }

}
