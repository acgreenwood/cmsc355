package sean.itr1;

/**
 * Created by Michael on 11/8/2016.
 */

public class HoldStatus {

    private boolean seriesHold;
    private int seriesSeason;
    private int seriesEpisode;
    private int seriesTimeStamp;
    private int seriesPageNumber;
    private int seriesChapter;

    public HoldStatus() {
        seriesHold = false;
        seriesSeason = 0;
        seriesEpisode = 0;
        seriesTimeStamp = 0;
        seriesPageNumber = 0;
        seriesChapter = 0;
    }

    public HoldStatus(boolean hold, int season, int episode, int timeStamp) {
        seriesHold = hold;
        seriesSeason = season;
        seriesEpisode = episode;
        seriesTimeStamp = 0;
        seriesPageNumber = 0;
        seriesChapter = 0;
    }

    public HoldStatus(boolean hold, int timeStamp) {
        seriesHold = hold;
        seriesTimeStamp = timeStamp;
        seriesSeason = 0;
        seriesEpisode = 0;
        seriesPageNumber = 0;
        seriesChapter = 0;
    }

    public HoldStatus(boolean hold, int pageNumber, int chapter) {
        seriesHold = hold;
        seriesTimeStamp = 0;
        seriesSeason = 0;
        seriesEpisode = 0;
        seriesPageNumber = pageNumber;
        seriesChapter = chapter;
    }

    public void setHoldStatus(boolean hold) {
        seriesHold = hold;
    }

    public void setSeriesSeason(int season) {
        seriesSeason = season;
    }

    public void setSeriesEpisode(int episode) {
        seriesEpisode = episode;
    }

    public void setSeriesTimeStamp(int timeStamp) {
        seriesTimeStamp = timeStamp;
    }

    public void setSeriesPageNumber(int pageNumber) { seriesPageNumber = pageNumber; }

    public void setSeriesChapter(int chapter) { seriesChapter = chapter; }

    public boolean getHold() {
        return seriesHold;
    }

    public int getSeriesSeason() {
        return seriesSeason;
    }

    public int getSeriesEpisode() {
        return seriesEpisode;
    }

    public int getSeriesTimeStamp() {
        return seriesTimeStamp;
    }

    public int getSeriesPageNumber() { return seriesPageNumber; }

    public int getSeriesChapter() { return seriesChapter; }
}
