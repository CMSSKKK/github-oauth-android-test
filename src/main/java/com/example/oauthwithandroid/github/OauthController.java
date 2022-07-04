package com.example.oauthwithandroid.github;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OauthController {

    private OauthService oauthService;

    @GetMapping("/github")
    public GithubUserInfo userInfo(String code) {
        GithubToken githubToken = oauthService.requestAccessToken(code);
        return oauthService.requestUserInfo(githubToken);
    }
}
