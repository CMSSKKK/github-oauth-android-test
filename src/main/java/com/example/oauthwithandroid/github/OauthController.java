package com.example.oauthwithandroid.github;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OauthController {

    private final OauthService oauthService;

    @GetMapping("/github")
    public GithubUserInfo userInfo(@RequestParam String code) {
        log.info("code = {}", code);
        GithubToken githubToken = oauthService.requestAccessToken(code);
        log.info("githubToken={}",githubToken.toHeader());
        GithubUserInfo githubUserInfo = oauthService.requestUserInfo(githubToken);
        log.info("githubUserInfo={},{}", githubUserInfo.getUserId(), githubUserInfo.getAvatarUrl());
        return githubUserInfo;
    }
}
