package sean.itr1;

import java.util.ArrayList;

/**
 * Created by northwind on 10/9/2016.
 */
public class MemoryDatabase {
    private static ArrayList<Series> archive = new ArrayList<Series>();

    public static ArrayList<Series> getArchive() {
        return archive;
    }

    static {
        archive.add(new Series(0, "Stranger Things", "television", "mystery"));
    }

    /**
     * Returns series, given an integer id
     * @param id integer id
     * @return series with id, or null if not found
     */
    public static Series getSeriesByID(int id) {
        for(Series element: archive) {
            if(element.getID() == id) {
                return element;
            }
        }
        return null;
    }

    /**
     * returns arraylist of series, with most relavent searches last
     * @param terms
     * @return
     */
    /** THIS NEEDS TO BE TESTED **/
    public static ArrayList<Series> searchByTerms(String terms) {
        ArrayList<Series> findings = new ArrayList<Series>();

        //separate each search term into termTokens
        String[] termTokens = terms.split(" ");

        //search for titles containing at least one search term
        for(Series element: archive) {
            for (int i = 0; i < termTokens.length; i++) {
                if (element.getTitle().toLowerCase().contains(termTokens[i].toLowerCase())) {
                    findings.add(element);
                    break;
                }
            }
        }

        //search for titles with all the terms
        //this might get slow for long lists
        for (int j = 2; j <= termTokens.length; j++) {
            for (int k = 0; k < findings.size(); k++) {
                int termsFound = 0;
                for (int i = 0; i < termTokens.length; i++) {
                    if (findings.get(k).getTitle().toLowerCase().contains(termTokens[i].toLowerCase())) {
                        termsFound++;
                    }
                    if (termsFound >= j) {
                        findings.add(findings.remove(k));
                    }
                }
            }
        }

        //search for titles with all terms in order together
        for (int k = 0; k < findings.size(); k++) {
            if( findings.get(k).getTitle().toLowerCase().contains(terms.toLowerCase())) {
                findings.add(findings.remove(k));
            }
        }
        //return the list of findings, which has most relevant listings at the end
        return findings;
    }



    public static void addSeries(Series new_series) {
        new_series.setID(archive.size());
        archive.add(new_series);
    }
}
