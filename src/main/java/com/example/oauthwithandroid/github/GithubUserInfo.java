package com.example.oauthwithandroid.github;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class GithubUserInfo {

    @JsonProperty("login")
    private String userId;
    @JsonProperty("avatar_url")
    private String avatarUrl;
}
