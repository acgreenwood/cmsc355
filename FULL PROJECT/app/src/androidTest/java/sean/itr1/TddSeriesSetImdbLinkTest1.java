package sean.itr1;

import org.junit.Test;


import static org.junit.Assert.*;

public class TddSeriesSetImdbLinkTest1 {

    //Issue: Edit Links Option: Scenario 1
    @Test
    public void setImdbLinkTest() throws Exception {
        Series newSeries = new Series(0, "hello", "hello", "hello");

        assertTrue(newSeries.setImdb("www.imdb.com/title/hello"));
    }
}