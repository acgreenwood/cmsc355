package sean.itr1;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TddSeriesSetImdbLinkTest2 {
    @Test
    public void setImdbLinkTest2() throws Exception {
        Series newSeries = new Series(0, "hello", "hello", "hello");

        assertFalse((newSeries.setImdb("www.imdb.com/hello")));
    }
}