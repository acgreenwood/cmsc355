package sean.itr1;

import android.webkit.URLUtil;

public class Series {

    /** Use these enums later */
    public static enum SeriesType {
        TELEVISION, MOVIE, ANIME, BOOK, INTERNET
    }

    public static enum SeriesGenre {
        ACTION, MYSTERY, ROMANCE, COMEDY, HORROR, DRAMA
    }

    private int seriesId;
    private String seriesTitle;
    private String seriesType;
    private String seriesGenre;
    private String seriesDescription;
    private String imdb;
    private String wiki;
    private HoldStatus seriesHold;

    public Series(int id, String title, String type, String genre) {
        seriesId = id;
        seriesTitle = title;
        seriesType = type;
        seriesGenre = genre;
        seriesHold = new HoldStatus();
    }

    public String getTitle() {
        return seriesTitle;
    }

    public String getType() {
        return seriesType;
    }

    public String getGenre() {
        return seriesGenre;
    }

    public String getDescription() {
        return seriesDescription;
    }

    public String getImdb() {
        return imdb;
    }

    public String getWiki() {
        return wiki;
    }

    public int getId() {
        return seriesId;
    }

    public void setId(int id) {
        seriesId = id;
    }

    public void setDescription(String description) {
        seriesDescription = description;
    }

    public boolean setImdb(String url) {

        if(URLUtil.isHttpUrl(url)) {
            if(url.length() < 26) {
                return false;
            }
            if(url.substring(7, 26).compareTo("www.imdb.com/title/") == 0) {
                imdb = url;
                return true;
            }
            else {
                return false;
            }
        }
        else if(URLUtil.isHttpsUrl(url)) {
            if (url.length() < 27) {
                return false;
            }
            if (url.substring(8, 27).compareTo("www.imdb.com/title/") == 0) {
                imdb = url;
                return true;
            } else {
                return false;
            }
        }
        if(url.length() < 19) {
            return false;
        }
        else if(url.substring(0, 19).compareTo("www.imdb.com/title/") == 0) {
            imdb = url;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean setWiki(String url) {
        if(URLUtil.isHttpUrl(url)) {
            if(url.length() < 29) {
                return false;
            }
            if(url.substring(9, 29).compareTo(".wikipedia.org/wiki/") == 0) {
                wiki = url;
                return true;
            }
            else {
                return false;
            }
        }
        else if(URLUtil.isHttpsUrl(url)) {
            if(url.length() < 30) {
                return false;
            }
            if(url.substring(10, 30).compareTo(".wikipedia.org/wiki/") == 0) {
                wiki = url;
                return true;
            }
            else {
                return false;
            }
        }
        if(url.length() < 20) {
            return false;
        }
        else if(url.substring(2, 22).compareTo(".wikipedia.org/wiki/") == 0) {
            imdb = url;
            return true;
        }
        else {
            return false;
        }
    }


    public HoldStatus getHold() {
        return seriesHold;
    }

    public void setHold(HoldStatus theHold) {
        seriesHold = theHold;
    }

    public String toString() {
        return "Title: " + getTitle()
                + "\nType: " + getType()
                + "\nGenre: " + getGenre() + "\n";
    }
}
