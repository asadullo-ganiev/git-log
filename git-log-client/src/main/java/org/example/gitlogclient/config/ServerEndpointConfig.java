package org.example.gitlogclient.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("app")
public class ServerEndpointConfig {

    private String gitServerEndpoint;

    public String getGitServerEndpoint() {
        return gitServerEndpoint;
    }

    public void setGitServerEndpoint(String gitServerEndpoint) {
        this.gitServerEndpoint = gitServerEndpoint;
    }
}
