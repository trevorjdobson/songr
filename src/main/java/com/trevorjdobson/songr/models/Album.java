package com.trevorjdobson.songr.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String title;
    String artist;
    int songCount;
    int length;
    String imageUrl;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "album")
    List<Song> songs;

    public Album(){}

    public Album(String title, String artist, int songCount, int length, String imageUrl){

        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
        this.imageUrl = imageUrl;
    }
    public String toString(){
        return "Album: " + title + " Artist: " + artist;
    }
    public List<Song> getSongs() {
        return songs;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getSongCount() {
        return songCount;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String url) {
        this.imageUrl = imageUrl;
    }
}
