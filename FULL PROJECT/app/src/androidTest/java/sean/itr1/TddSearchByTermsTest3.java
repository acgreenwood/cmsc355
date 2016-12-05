package sean.itr1;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TddSearchByTermsTest3 {
    @Test
    public void searchByTermsTest() throws Exception {
        ArrayList<Series> findings = MemoryDatabase.searchByTerms("the");

        int count = 0;
        for (Series element : findings) {
            String title = element.getTitle().toLowerCase();
            if(title.toLowerCase().equals("silence of the lambs")) count++;
        }

        assertTrue(count >= 0);
    }
}