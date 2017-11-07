package com.project.achemei.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fabio on 27/10/2017.
 */

public class ImageGallery {

    @SerializedName("id")
    private int id;
    @SerializedName("linkOriginal")
    private String originalLink;
    @SerializedName("linkThumbnail")
    private String thumbnailLink;

    public ImageGallery(int id, String originalLink, String thumbnailLink) {
        this.id = id;
        this.originalLink = originalLink;
        this.thumbnailLink = thumbnailLink;
    }

    public ImageGallery() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginalLink() {
        return originalLink;
    }

    public void setOriginalLink(String originalLink) {
        this.originalLink = originalLink;
    }

    public String getThumbnailLink() {
        return thumbnailLink;
    }

    public void setThumbnailLink(String thumbnailLink) {
        this.thumbnailLink = thumbnailLink;
    }
}
