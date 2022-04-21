package com.posts.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatePostRequestBody {

    @Setter
    private int statusCode;

    private String owner;
    private String image;
    private String text;
    private int likes;
    private List<String> tags;

    public CreatePostRequestBody(CreatePostRequestBody.Builder builder) {
        this.owner = builder.owner;
        this.image = builder.image;
        this.text = builder.text;
        this.likes = builder.likes;
        this.tags = builder.tags;
    }

    public static class Builder {
        private String owner;
        private String image;
        private String text;
        private int likes;
        private List<String> tags;


        public Builder() {
            this.owner = "60d0fe4f5311236168a109ca";
            this.image = "https://randomuser.me/api/portraits/med/men/25.jpg";
            this.text = "Create Dog Post Test";
            this.likes = 5;
            this.tags = Arrays.asList(new String[]{"dog", "breed", "pet"});
        }

        public CreatePostRequestBody.Builder owner(String owner) {
            this.owner = owner;
            return this;
        }

        public CreatePostRequestBody.Builder image(String image) {
            this.image = image;
            return this;
        }

        public CreatePostRequestBody.Builder text(String text) {
            this.text = text;
            return this;
        }

        public CreatePostRequestBody.Builder likes(int likes) {
            this.likes = likes;
            return this;
        }

        public CreatePostRequestBody.Builder tags(List<String> tags) {
            this.tags = tags;
            return this;
        }

        public CreatePostRequestBody build() {
            return new CreatePostRequestBody(this);
        }
    }
}