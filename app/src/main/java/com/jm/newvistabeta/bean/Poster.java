package com.jm.newvistabeta.bean;

/**
 * Created by Johnny on 1/21/2018.
 */

public class Poster {
    private int id;
    private String movieTitle;
    private byte[] poster;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public byte[] getPoster() {
        return poster;
    }

    public void setPoster(byte[] poster) {
        this.poster = poster;
    }
}
