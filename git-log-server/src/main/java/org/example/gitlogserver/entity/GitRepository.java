package org.example.gitlogserver.entity;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.revwalk.RevCommit;

import java.util.concurrent.ConcurrentHashMap;

public class GitRepository {

    private final ConcurrentHashMap<String, Git> repositories = new ConcurrentHashMap<>();

    public void addRepository(String url, Git git) {
        repositories.put(url, git);
    }

    public Git getRepository(String url) {
        return repositories.get(url);
    }
}
