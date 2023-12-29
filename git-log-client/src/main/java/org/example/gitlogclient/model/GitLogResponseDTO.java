package org.example.gitlogclient.model;

import java.util.Date;

public class GitLogResponseDTO {

    String author;
    String date;
    String commitMessage;

    public GitLogResponseDTO(String author, String date, String commitMessage) {
        this.author = author;
        this.date = date;
        this.commitMessage = commitMessage;
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
