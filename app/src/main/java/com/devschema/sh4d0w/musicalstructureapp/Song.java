package com.devschema.sh4d0w.musicalstructureapp;

public class Song {
    private int Id;
    private String Title;
    private String Artist;
    private double Duration;

    public Song() {
    }

    public Song(int id, String title, String artist, double duration) {
        Id = id;
        Title = title;
        Artist = artist;
        Duration = duration;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getArtist() {
        return Artist;
    }

    public void setArtist(String artist) {
        Artist = artist;
    }

    public double getDuration() {
        return Duration;
    }

    public void setDuration(double duration) {
        Duration = duration;
    }

}
