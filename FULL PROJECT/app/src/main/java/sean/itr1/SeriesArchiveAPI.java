package sean.itr1;

public class SeriesArchiveApi {

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
        /** TODO this only accesses MemoryDatabase, temp memory*/
        return MemoryDatabase.getArchive().toArray(new Series[] {});
    }

    public static Series getSeriesById(int id) {
        /** TODO this only accesses MemoryDatabase, temp memory*/
        return MemoryDatabase.getSeriesById( id );
    }

    public static void addSeries(Series newSeries) {
        MemoryDatabase.addSeries(newSeries);
    }

    public static int getArchiveSize() {
        return MemoryDatabase.getArchiveSize();
    }
}
