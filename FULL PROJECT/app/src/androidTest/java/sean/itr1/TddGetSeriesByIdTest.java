package sean.itr1;

import org.junit.Test;

import static org.junit.Assert.*;

public class TddGetSeriesByIdTest {
    @Test
    public void getSeriesByIdTest() throws Exception {
        assertEquals(MemoryDatabase.getSeriesById(1).getId(), 1);
    }
}
