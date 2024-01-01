package org.example.gitlogserver.entity;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.revwalk.RevCommit;

public classGitRepository {



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
