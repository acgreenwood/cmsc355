package sean.itr1;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TddSeriesSetWikipediaLinkTest2 {
    @Test
    public void setWikipediaLinkTest() throws Exception {
        Series newSeries = new Series(0, "hello", "hello", "hello");

        assertTrue(newSeries.setWiki("https://en.wikipedia.org/wiki/"));
    }
}