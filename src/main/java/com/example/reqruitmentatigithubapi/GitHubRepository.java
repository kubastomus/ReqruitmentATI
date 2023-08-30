package com.example.reqruitmentatigithubapi;

import java.util.List;

public class GitHubRepository {

    private String name;
    private boolean isFork;
    private GitHubOwner owner;
    private List<GItHubBranch> branches;

    public GitHubRepository() {
    }

    public GitHubRepository(String name, boolean isFork, GitHubOwner owner, List<GItHubBranch> branches) {
        this.name = name;
        this.isFork = isFork;
        this.owner = owner;
        this.branches = branches;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFork() {
        return isFork;
    }

    public void setFork(boolean fork) {
        isFork = fork;
    }

    public GitHubOwner getOwner() {
        return owner;
    }

    public void setOwner(GitHubOwner owner) {
        this.owner = owner;
    }

    public List<GItHubBranch> getBranches() {
        return branches;
    }

    public void setBranches(List<GItHubBranch> branches) {
        this.branches = branches;
    }



}
