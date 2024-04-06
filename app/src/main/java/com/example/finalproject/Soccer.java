package com.example.finalproject;

public class Soccer {

    private String title, thumbnail, url, date, competition;

    public Soccer(String title, String thumbnail, String url, String date, String competition) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.url = url;
        this.date = date;
        this.competition = competition;
    }

    public String getTitle() {
        return title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getUrl() {
        return url;
    }

    public String getDate() {
        return date;
    }

    public String getCompetition() {
        return competition;
    }

}
