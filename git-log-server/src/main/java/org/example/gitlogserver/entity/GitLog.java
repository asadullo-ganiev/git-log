package org.example.gitlogserver.entity;

import org.eclipse.jgit.revwalk.RevCommit;

import java.util.Date;

public class GitLog {

    String author;
    String date;
    String commitMessage;

    public GitLog(String author, String date, String commitMessage) {
        this.author = author;
        this.date = date;
        this.commitMessage = commitMessage;
    }

    public static GitLog toGitLog(RevCommit commit) {
        Date commitDate = new Date((long) commit.getCommitTime() * 1000);
        return new GitLog(commit.getAuthorIdent().getName(), commitDate.toString(), commit.getFullMessage());
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCommitMessage() {
        return commitMessage;
    }

    public void setCommitMessage(String commitMessage) {
        this.commitMessage = commitMessage;
    }
}
