package sean.itr1;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TddSearchByTermsTest2 {
    @Test
    public void searchByTermsTest() throws Exception {
        ArrayList<Series> findings = MemoryDatabase.searchByTerms("Silence of the Lambs");

        for (Series element : findings) {
            String title = element.getTitle().toLowerCase();
            assertTrue(title.contains("silence") || title.contains("of") || title.contains("the") || title.contains("lambs"));
        }
    }
}