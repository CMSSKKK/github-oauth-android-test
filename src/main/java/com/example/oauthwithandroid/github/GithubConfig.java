package com.example.oauthwithandroid.github;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(GithubProperties.class)
@RequiredArgsConstructor
public class GithubConfig {

    private final GithubProperties githubProperties;

}
