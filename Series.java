package com.successsquad.seanapplication;

/**
 * Created by northwind on 10/6/2016.
 */
public class Series {

    /** Use these enums later */
    public static enum SERIES_TYPE {
        TELEVISION, MOVIE, ANIME, BOOK
    }
    public static enum SERIES_GENRE {
        ACTION, MYSTERY, ROMANCE, COMEDY, HORROR
    }

    private int series_id;
    private String series_title;
    private String series_type;
    private String series_genre;
    private String series_description;

    public Series(int id, String title, String type, String genre) {
        series_id = id;
        series_title = title;
        series_type = type;
        series_genre = genre;
    }

    public String getTitle() {
        return series_title;
    }

    public String getType() {
        return series_type;
    }

    public String getGenre() {
        return series_genre;
    }

    public String getDescription() {
        return series_description;
    }

    public int getID() { return series_id; }

    public void setDescription(String description) {
        series_description = description;
    }
}
