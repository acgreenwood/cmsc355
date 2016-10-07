package sean.itr1;

/**
 * Created by northwind on 10/6/2016.
 */
public class SeriesArchiveAPI {

    /**
     * Search through the database
     * returns all series containing the search terms
     */
    public static Series[] searchByTerms(String searchTerms) {
        /** TODO actaully search through the database*/
        return new Series[] {new Series(1, "Stranger Things", "television", "mystery")};
    }

    /** dangerous once the archive becomes big **/
    public static Series[] getArchive() {
        /** TODO actually look in to the archive */
        return new Series[] {new Series(1, "Stranger Things", "television", "mystery")};
    }

    public static Series getSeriesByID(int id) {
        /** TODO actually look in to the archive */
        if(id == 1) {
            return new Series(1, "Stranger Things", "television", "mystery");
        }
        else return null;
    }
}
