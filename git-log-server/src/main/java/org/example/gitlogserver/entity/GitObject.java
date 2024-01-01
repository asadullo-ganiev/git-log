package org.example.gitlogserver.entity;

import org.eclipse.jgit.api.Git;

public class GitObject {

    Git git;
    String url;
    Boolean connected = Boolean.FALSE;

    public void connect(String repositoryUrl, Git git) {
        this.git = git;
        this.url = repositoryUrl;
        this.connected = Boolean.TRUE;
    }

    public Git getGit() {
        return git;
    }

    public Boolean getConnected() {
        return connected;
    }
}
