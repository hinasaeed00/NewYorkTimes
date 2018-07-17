package com.example.newyorktime.newyorktimes.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Article implements Serializable {
    private String title, byline, published_date;
    public String id;
    @SerializedName("media")
    private List<Media> media;


    public Article() {

    }

    public Article(String id,String title, String byline, String published_date,List<Media> media) {
        this.id=id;
        this.title = title;
        this.byline = byline;
        this.published_date = published_date;
        this.media=media;

    }
    public List<Media> getMedia() {
        return media;
    }

    public void setMedia(List<Media> media) {
        this.media = media;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }
    public String getPublished_date() {
        return published_date;
    }

    public void setPublished_date(String published_date) {
        this.published_date = published_date;
    }
    public class Media implements Serializable{
        public String caption;
        @SerializedName("media-metadata")
        public List<metadata> media_metadata;

        public String getCaption() {
            return caption;
        }

        public void setCaption(String caption) {
            this.caption = caption;
        }

        public List<metadata> getMedia_metadata() {
            return media_metadata;
        }

        public void setMedia_metadata(List<metadata> media_metadata) {
            this.media_metadata = media_metadata;
        }
    }
    public class metadata implements Serializable
    {
        public String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

}
