package sean.itr1;

import java.util.ArrayList;

/**
 * Created by northwind on 10/6/2016.
 */
public class SeriesArchiveAPI {

    /**
     * Search through the database
     * returns all series containing the search terms
     */
    public static Series[] searchByTerms(String searchTerms) {
        /** TODO this only accesses MemoryDatabase, temp memory*/
        return MemoryDatabase.searchByTerms(searchTerms).toArray(new Series[] {});
    }

    /** dangerous once the archive becomes big **/
    public static Series[] getArchive() {
        /** TODO this only accesses MemoryDatase, temp memory*/
        return MemoryDatabase.getArchive().toArray(new Series[] {});
    }

    public static Series getSeriesByID(int id) {
        /** TODO this only accesses MemoryDatase, temp memory*/
        return MemoryDatabase.getSeriesByID( id );
    }

    public static void addSeries(Series new_series) {
        MemoryDatabase.addSeries(new_series);
    }
}
