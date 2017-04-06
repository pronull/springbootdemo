package com.github.entity;

public class Music {
    private Long id;

    private Integer musicId;

    private String musicName;

    private String musicAuthor;

    private String musicCollection;

    private String musicFileAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMusicId() {
        return musicId;
    }

    public void setMusicId(Integer musicId) {
        this.musicId = musicId;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName == null ? null : musicName.trim();
    }

    public String getMusicAuthor() {
        return musicAuthor;
    }

    public void setMusicAuthor(String musicAuthor) {
        this.musicAuthor = musicAuthor == null ? null : musicAuthor.trim();
    }

    public String getMusicCollection() {
        return musicCollection;
    }

    public void setMusicCollection(String musicCollection) {
        this.musicCollection = musicCollection == null ? null : musicCollection.trim();
    }

    public String getMusicFileAddress() {
        return musicFileAddress;
    }

    public void setMusicFileAddress(String musicFileAddress) {
        this.musicFileAddress = musicFileAddress == null ? null : musicFileAddress.trim();
    }
}