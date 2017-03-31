package com.dozydroid.githubjavapk.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by MIRSAAB on 3/29/2017.
 */

public class Item {
    @SerializedName("login")
    @Expose
    private String login;

    @SerializedName("avatar_url")
    @Expose
    private String avatar_url;

    @SerializedName("html_url")
    @Expose
    private String html_url;

    @SerializedName("followers_url")
    @Expose
    private String followers_url;

    @SerializedName("following_url")
    @Expose
    private String following_url;

    @SerializedName("starred_url")
    @Expose
    private String starred_url;

    public Item(String login, String avatar_url, String html_url, String followers_url, String following_url, String starred_url) {
        this.login = login;
        this.avatar_url = avatar_url;
        this.html_url = html_url;
        this.followers_url = followers_url;
        this.following_url = following_url;
        this.starred_url = starred_url;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public String getFollowers_url() {
        return followers_url;
    }

    public void setFollowers_url(String followers_url) {
        this.followers_url = followers_url;
    }

    public String getFollowing_url() {
        return following_url;
    }

    public void setFollowing_url(String following_url) {
        this.following_url = following_url;
    }

    public String getStarred_url() {
        return starred_url;
    }

    public void setStarred_url(String starred_url) {
        this.starred_url = starred_url;
    }
}
