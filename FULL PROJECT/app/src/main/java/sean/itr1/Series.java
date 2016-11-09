package sean.itr1;

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

    public Series(int id, String title, String type, String genre) {
        seriesId = id;
        seriesTitle = title;
        seriesType = type;
        seriesGenre = genre;
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

    public int getId() {
        return seriesId;
    }

    public void setId(int id) {
        seriesId = id;
    }

    public void setDescription(String description) {
        seriesDescription = description;
    }

    public String toString() {
        return "Title: " + getTitle()
                + "\nType: " + getType()
                + "\nGenre: " + getGenre() + "\n";
    }
}
