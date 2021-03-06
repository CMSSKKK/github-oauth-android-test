package com.example.oauthwithandroid.github;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
@Slf4j
public class OauthService {

    private static final String ACCESS_TOKEN_URL = "https://github.com/login/oauth/access_token";
    private static final String USER_INFO_API = "https://api.github.com/user";

    private final GithubProperties githubProperties;

    public GithubToken requestAccessToken(String code) {
        log.info("githubproperties={},{}", githubProperties.getClientId(), githubProperties.getClientSecret());
        return WebClient.create().post()
                .uri(ACCESS_TOKEN_URL)
                .bodyValue(
                        GithubTokenRequest.of(githubProperties.getClientId(), githubProperties.getClientSecret(), code)
                )
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(GithubToken.class)
                .block();
    }

    public GithubUserInfo requestUserInfo(GithubToken githubToken) {
        return WebClient.create().get()
                .uri(USER_INFO_API)
                .header(HttpHeaders.AUTHORIZATION, githubToken.toHeader())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(GithubUserInfo.class)
                .block();
    }
}
