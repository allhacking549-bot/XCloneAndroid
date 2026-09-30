package com.example.xclone;

public class Post {
    public long id;
    public String author;
    public String handle;
    public String content;
    public String time;
    public int replies;
    public int retweets;
    public int likes;
    public boolean liked;

    public Post(long id, String author, String handle, String content, String time, int replies, int retweets, int likes, boolean liked) {
        this.id = id;
        this.author = author;
        this.handle = handle;
        this.content = content;
        this.time = time;
        this.replies = replies;
        this.retweets = retweets;
        this.likes = likes;
        this.liked = liked;
    }
}