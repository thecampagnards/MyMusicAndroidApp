package com.mymusic.app;


import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by Valdio Veliu on 16-07-18.
 */
public class Audio implements Serializable {

    private String data;
    private String title;
    private String album;
    private String artist;
    private String image;
    private Bitmap imageBitmap;

    public Audio(String data, String title, String album, String artist, String image, Bitmap imageBitmap) {
        this.data = data;
        this.title = title;
        this.album = album;
        this.artist = artist;
        this.image = image;
        this.imageBitmap = imageBitmap;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Bitmap getImageBitmap() {
        return imageBitmap;
    }

    public void setImageBitmap(Bitmap imageBit) {
        this.imageBitmap = imageBit;
    }
}
