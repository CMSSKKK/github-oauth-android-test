package com.example.oauthwithandroid.github;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.PropertySource;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "github")
@Setter
@PropertySource("classpath:auth.yml")
public class GithubProperties {

    @JsonProperty("client_id")
    private String clientId;
    @JsonProperty("client_secret")
    private String clientSecret;
}
