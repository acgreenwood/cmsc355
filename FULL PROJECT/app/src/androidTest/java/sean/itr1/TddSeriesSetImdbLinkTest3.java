package sean.itr1;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TddSeriesSetImdbLinkTest3 {
    //Issue: Edit Links Option: Scenario 3
    @Test
    public void setImdbLinkTest3() throws Exception {
        Series newSeries = new Series(0, "hello", "hello", "hello");

        assertTrue(newSeries.setImdb("http://www.imdb.com/title/hello"));
    }
}