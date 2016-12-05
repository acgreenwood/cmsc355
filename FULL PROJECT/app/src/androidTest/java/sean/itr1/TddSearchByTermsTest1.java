package sean.itr1;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TddSearchByTermsTest1 {
    //Issue: Memory Database (4 TDD Tests): Scenario 2
    @Test
    public void searchByTermsTest() throws Exception {
        ArrayList<Series> findings = MemoryDatabase.searchByTerms("Silence of the Lambs");
        int count = 0;
        for (Series element : findings) {
            count++;
        }
        assertTrue(count > 0);
    }
}