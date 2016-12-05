package sean.itr1;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TddSeriesSetWikipediaLinkTest3 {
    //Issue: Edit Links Option: Scenario 6
    @Test
    public void setWikipediaLinkTest() throws Exception {
        Series newSeries = new Series(0, "hello", "hello", "hello");

        assertFalse(newSeries.setWiki("https://www.wikipedia/wiki/hello"));
    }
}