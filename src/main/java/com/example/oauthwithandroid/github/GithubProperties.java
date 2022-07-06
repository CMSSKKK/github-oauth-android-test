package com.example.oauthwithandroid.github;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.PropertySource;

@Getter
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "github")
@PropertySource("classpath:auth.yml")
@ConstructorBinding
public class GithubProperties {

    @JsonProperty("client_id")
    private final String clientId;
    @JsonProperty("client_secret")
    private final String clientSecret;
}
