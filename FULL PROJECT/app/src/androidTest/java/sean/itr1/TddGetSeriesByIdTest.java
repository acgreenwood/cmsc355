package sean.itr1;

import org.junit.Test;

import static org.junit.Assert.*;

public class TddGetSeriesByIdTest {
    //Issue: Memory Database (4 TDD Tests): Scenario 1
    @Test
    public void getSeriesByIdTest() throws Exception {
        assertEquals(MemoryDatabase.getSeriesById(1).getId(), 1);
    }
}
