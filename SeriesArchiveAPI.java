package com.successsquad.seanapplication;

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
        /** TODO this only accesses MemoryDatase, temp memory*/
        return (Series[]) MemoryDatabase.searchByTerms(searchTerms).toArray();
    }

    /** dangerous once the archive becomes big **/
    public static Series[] getArchive() {
        /** TODO this only accesses MemoryDatase, temp memory*/
        return (Series[]) MemoryDatabase.getArchive().toArray();
    }

    public static Series getSeriesByID(int id) {
        /** TODO this only accesses MemoryDatase, temp memory*/
        return MemoryDatabase.getSeriesByID( id );
    }

    public static void addSeries(Series new_series) {
        MemoryDatabase.addSeries(new_series);
    }
}
